package com.arslan.starprofileskmm.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.arslan.starprofileskmm.domain.models.StarRepo
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ExpandableRepo(modifier: Modifier, starRepo: StarRepo) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 400,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .noRippleClickable {
                expanded = !expanded
            }.testTag("repo")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.Top
            ) {
                if (starRepo.owner?.avatarUrl.isNullOrEmpty()) {
                    Icon(
                        modifier = modifier
                            .size(50.dp)
                            .background(Color.LightGray.copy(alpha = 0.3f))
                            .padding(4.dp),
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null,
                    )
                } else {
                    val painterResource = asyncPainterResource(starRepo.owner!!.avatarUrl!!)
                    KamelImage(
                        painterResource,
                        contentDescription = null,
                        modifier = modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(50.dp))
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = starRepo.name ?: "",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleMedium.copy(MaterialTheme.colorScheme.onSurface)
                    )
                    Text(
                        text = starRepo.fullName ?: "",
                        modifier = Modifier
                            .height(15.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    if (expanded) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = starRepo.description ?: "",
                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 5
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RandomColorCircle()
                            Spacer(modifier.width(5.dp))
                            Text(
                                text = starRepo.language ?: "",
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier.width(40.dp))
                            GoldenStar()
                            Spacer(modifier.width(5.dp))
                            Text(
                                text = starRepo.starsCount.toString(),
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .background(Color.LightGray.copy(alpha = 0.3f))
            )
        }
    }
}

@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}