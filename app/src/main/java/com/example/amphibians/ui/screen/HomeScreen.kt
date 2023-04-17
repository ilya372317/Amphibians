package com.example.amphibians.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.viewModel.AmphibianUiState
import com.example.amphibians.ui.viewModel.AmphibiansViewModel

@Composable
fun AmphibianApp(viewModel: AmphibiansViewModel, modifier: Modifier = Modifier) {
    when (val amphibianUiState = viewModel.uiState) {
        is AmphibianUiState.Success -> AmphibianList(amphibians = amphibianUiState.amphibians)
        is AmphibianUiState.Loading -> AmphibianLoading()
        is AmphibianUiState.Error -> AmphibianError()
    }
}

@Composable
fun AmphibianError(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.failed_loading),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun AmphibianLoading(modifier: Modifier = Modifier) {

}

@Composable
fun AmphibianList(amphibians: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(amphibians) { amphibian ->
            AmphibianCard(amphibian = amphibian)
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column() {
            Text(amphibian.name)
            Text(amphibian.description)
            Text(amphibian.type)
            Text(amphibian.imgSrc)
        }
    }
}