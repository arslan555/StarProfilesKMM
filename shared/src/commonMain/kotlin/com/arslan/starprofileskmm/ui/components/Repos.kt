package com.arslan.starprofileskmm.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arslan.starprofileskmm.domain.models.StarRepo

@Composable
fun Repos(modifier: Modifier, repos: List<StarRepo>) {
    LazyColumn(modifier = modifier) {
        items(repos) {
            ExpandableRepo(modifier = Modifier, it)
        }
    }
}
