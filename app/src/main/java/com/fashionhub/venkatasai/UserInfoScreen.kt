

package com.fashionhub.venkatasai

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fashionhub.venkatasai.components.HeadingTextComponent
import com.fashionhub.venkatasai.ui.theme.FashionstoreAppTheme
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min

class UserProfileActivity : ComponentActivity() {
    enum class CameraPermissionStatus { NoPermission, PermissionGranted, PermissionDenied }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cameraPermissionStatusState = mutableStateOf(CameraPermissionStatus.NoPermission)
        val photoUriState: MutableState<Uri?> = mutableStateOf(null)
        val hasPhotoState = mutableStateOf(value = false)
        val resolver = applicationContext.contentResolver

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionGranted
                } else {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionDenied
                }
            }

        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { isSaved ->
                hasPhotoState.value = isSaved
            }

        val takePhoto: () -> Unit = {
            hasPhotoState.value = false

            val values = ContentValues().apply {
                val title = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                put(MediaStore.Images.Media.TITLE, "Compose Camera Example Image - $title")
                put(MediaStore.Images.Media.DISPLAY_NAME, title)
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())
            }

            val uri = resolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values
            )
            takePhotoLauncher.launch(uri)
            photoUriState.value = uri
        }

        val getThumbnail: (Uri?) -> ImageBitmap? = { uri ->
            val targetSize = 256f
            uri?.let {
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val height = it.height.toFloat()
                val width = it.width.toFloat()
                val scaleFactor = min(targetSize / height, targetSize / width)
                Bitmap.createScaledBitmap(it, (scaleFactor * width).toInt(), (scaleFactor * height).toInt(), true)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()
        }

        val getFullImage: (Uri?) -> ImageBitmap? = { uri ->
            uri?.let {
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()
        }

        setContent {
            FashionstoreAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "profile") {
                    composable("profile") {
                        UserProfileScreen(
                            navController = navController,
                            cameraPermissionStatusState = cameraPermissionStatusState,
                            photoUriState = photoUriState,
                            hasPhotoState = hasPhotoState,
                            resolver = resolver,
                            requestPermissionLauncher = requestPermissionLauncher,
                            takePhotoLauncher = takePhotoLauncher,
                            takePhoto = takePhoto,
                            getThumbnail = getThumbnail,
                            getFullImage = getFullImage
                        )
                    }
                    // Add other destinations here if needed
                }
            }
        }
    }

    private fun getImageRotation(resolver: ContentResolver, uri: Uri): Int {
        val cursor = resolver.query(uri, arrayOf(MediaStore.Images.Media.ORIENTATION), null, null, null)
        var result = 0

        cursor?.apply {
            moveToFirst()
            val index = getColumnIndex(MediaStore.Images.Media.ORIENTATION)
            result = getInt(index)
            close()
        }
        return result
    }
}

@Composable
fun UserProfileScreen(
    navController: NavController,
    cameraPermissionStatusState: MutableState<UserProfileActivity.CameraPermissionStatus>,
    photoUriState: MutableState<Uri?>,
    hasPhotoState: MutableState<Boolean>,
    resolver: ContentResolver,
    requestPermissionLauncher: ActivityResultLauncher<String>,
    takePhotoLauncher: ActivityResultLauncher<Uri>,
    takePhoto: () -> Unit,
    getThumbnail: (Uri?) -> ImageBitmap?,
    getFullImage: (Uri?) -> ImageBitmap?
) {
    val context = LocalContext.current
    val cameraPermissionStatus by remember { cameraPermissionStatusState }
    val hasPhoto by remember { hasPhotoState }
    var shouldShowFullImage by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }

    var name by remember { mutableStateOf("Venkat") }
    var email by remember { mutableStateOf("V@gmail.com") }
    var location by remember { mutableStateOf("Middlesbrough") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TakePhotoButton(
                cameraPermissionStatus = cameraPermissionStatus,
                requestPermissionLauncher = requestPermissionLauncher,
                takePhoto = takePhoto
            )
            if (hasPhoto) {
                val bitmap = getThumbnail(photoUriState.value)
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Thumbnail of Saved Photo",
                        modifier = Modifier.clickable {
                            shouldShowFullImage = true
                        }
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.pl),
                contentDescription = "",
                modifier = Modifier
                    .offset(x = 7.dp, y = 3.dp)
                    .requiredWidth(100.dp)
                    .requiredHeight(104.dp)
                    .clip(RoundedCornerShape(24.dp))
            )

            if (isEditing) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email Id") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = location,
                    onValueChange = { location = it },
                    label = { Text("Location") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            } else {
                HeadingTextComponent(value = "Name  : $name")
                Spacer(modifier = Modifier.height(15.dp))

                HeadingTextComponent(value = "Email Id : $email")
                Spacer(modifier = Modifier.height(15.dp))

                HeadingTextComponent(value = "Location : $location")
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                OutlinedButton(
                    onClick = { isEditing = !isEditing }
                ) {
                    Text(if (isEditing) "Save" else "Edit")
                }
                Spacer(modifier = Modifier.width(15.dp))

                // Back button only shown when not editing
                if (!isEditing) {
                    Button(
                        modifier = Modifier
                            .wrapContentWidth()
                            .heightIn(48.dp),
                        onClick = {
                            val fashion=""
                            context.startActivity(
                                Intent(context, MainActivity::class.java)
                                    .putExtra("Fashion", fashion))
                        },
                        contentPadding = PaddingValues(),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text("Back")
                    }
                }
            }
        }

        if (shouldShowFullImage && hasPhoto) {
            val bitmap = getFullImage(photoUriState.value)
            if (bitmap != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            shouldShowFullImage = false
                        }
                ) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Full image of Saved Photo",
                        modifier = Modifier.align(Alignment.Center)
                    )
                    Surface(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .align(Alignment.Center)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Click to Close",
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
                }
            } else {
                shouldShowFullImage = false
            }
        }
    }
}

@Composable
fun TakePhotoButton(
    cameraPermissionStatus: UserProfileActivity.CameraPermissionStatus,
    requestPermissionLauncher: ActivityResultLauncher<String>,
    takePhoto: () -> Unit
) {
    OutlinedButton(
        onClick = {
            when (cameraPermissionStatus) {
                UserProfileActivity.CameraPermissionStatus.NoPermission ->
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)

                UserProfileActivity.CameraPermissionStatus.PermissionGranted ->
                    takePhoto()

                UserProfileActivity.CameraPermissionStatus.PermissionDenied -> {}

            }
        }
    ) {
        when (cameraPermissionStatus) {
            UserProfileActivity.CameraPermissionStatus.NoPermission ->
                Text(text = "Request Camera Permissions")

            UserProfileActivity.CameraPermissionStatus.PermissionDenied ->
                Text(text = "Camera Permissions Have Been Denied")

            UserProfileActivity.CameraPermissionStatus.PermissionGranted ->
                Text(text = "Take Photo")
        }
    }



}
