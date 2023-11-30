package com.koleff.habittracker.ui.composable

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.koleff.habittracker.common.DataManager
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.data.Skill


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        //Image first, then gradient over it, then text over the gradient...
        Box(modifier = Modifier
            .height(200.dp)
            .clickable { onClick.invoke() }
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black)
                        )
                    )
            )

            //Have the text in a box positioned at bottom start
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic,
                    ),
                )
            }
        }
    }
}

@Composable
fun SkillGrid(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    skillList: List<Skill>
) {
    Row(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(skillList.size / 2) { id ->
                val currentSkillId = id * 2
                val currentSkill = skillList[currentSkillId]

                ImageCard(
                    painter = painterResource(id = currentSkill.imageId),
                    contentDescription = currentSkill.description,
                    title = currentSkill.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    openSkillDetailsScreen(currentSkillId, navController)
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(skillList.size / 2) { id ->
                val currentSkillId = id * 2 + 1
                val currentSkill = skillList[currentSkillId]

                //Top margin for second column
                Spacer(
                    modifier = Modifier.height(
                        if (id == 0) 50.dp else 0.dp
                    )
                )

                ImageCard(
                    painter = painterResource(id = currentSkill.imageId),
                    contentDescription = currentSkill.description,
                    title = currentSkill.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    openSkillDetailsScreen(currentSkillId, navController)
                }
            }
        }
    }
}

fun openSkillDetailsScreen(currentSkillId: Int, navController: NavHostController) {
    navController.navigate(MainScreen.SkillDetails.createRoute(currentSkillId)) //TODO: only pass the id!
}

