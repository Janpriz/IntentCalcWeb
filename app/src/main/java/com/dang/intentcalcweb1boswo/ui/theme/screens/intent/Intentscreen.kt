package com.dang.intentcalcweb1boswo.ui.theme.screens.intent


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Intent_Screen(navcontroller: NavHostController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = "Intent Screen",
            color = Color.Red,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+0"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "call",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = { val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)},
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "share",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val uri = Uri.parse("smsto:07456789")

                val intent = Intent(Intent.ACTION_SENDTO, uri)

                intent.putExtra("Hello", "How is todays weather")

                context.startActivity(intent)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "sms",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = { val phone = "0720176900"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                context.startActivity(intent)},
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Dial",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                startActivityForResult(context as Activity,takePictureIntent,1,null)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Camera",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Email",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "STK",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto",
                    "damianbwire88@gmail.com",
                    null
                ))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                context.startActivity(emailIntent)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Email",
                fontSize = 30.sp
            )
        }

    }
}

@Preview
@Composable
private fun Intentprev() {
    Intent_Screen(rememberNavController())
}