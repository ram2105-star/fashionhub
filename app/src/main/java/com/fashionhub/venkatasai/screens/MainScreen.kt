
package com.fashionhub.venkatasai.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fashionhub.venkatasai.DetailsPageActivity

import com.fashionhub.venkatasai.R
import com.fashionhub.venkatasai.UserProfileActivity
import com.fashionhub.venkatasai.components.AppToolbar
import com.fashionhub.venkatasai.components.NavigationDrawerBody
import com.fashionhub.venkatasai.components.NavigationDrawerHeader

import com.fashionhub.venkatasai.data.FashionHubhome.FashiomHubViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: FashiomHubViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 640.dp)
                        .background(color = Color.White)
                ) {


                    val localContext = LocalContext.current


                    Image(
                        painter = painterResource(id = R.drawable.ban),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 1.dp,
                                y = 0.dp
                            )
                            .requiredWidth(width = 455.dp)
                            .requiredHeight(height = 260.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 190.dp
                            )
                            .requiredWidth(width = 370.dp)
                            .requiredHeight(height = 140.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )

                    {
                        Image(
                            painter = painterResource(id = R.drawable.bow),
                            contentDescription = "",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 1.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 360.dp)
                                .requiredHeight(height = 150.dp)
                                .clip(shape = RoundedCornerShape(15.dp))

                        )
                    }

                    //1
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 13.dp,
                                y = 460.dp)
                            .requiredWidth(width = 380.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.giw),
                            contentDescription = " ",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 11.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 360.dp)
                                .requiredHeight(height = 260.dp)
                        )


                    }
                    //2
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 14.dp,
                                y = 330.dp)
                            .requiredWidth(width = 375.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.mew),
                            contentDescription = "",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 11.dp,
                                    y =0.dp)
                                .requiredWidth(width = 360.dp)
                                .requiredHeight(height = 200.dp)

                                .clip(shape = RoundedCornerShape(20.dp))

                        )}


                    //3
                }

            }
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}