package com.example.bluetoohlowenergyapp.presentation

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bluetoohlowenergyapp.presentation.components.MyCardItem
import com.example.bluetoohlowenergyapp.ui.theme.BluetoohLowEnergyAppTheme

class MainActivity : ComponentActivity() {
    val sampleItems = listOf(
        MyCardItem("Title 1", "Description 1", R.drawable.ic_menu_gallery),
        MyCardItem("Title 2", "Description 2", R.drawable.ic_menu_camera),
        MyCardItem("Title 3", "Description 3", R.drawable.ic_menu_compass)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BluetoohLowEnergyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchBLE(modifier = Modifier.padding(innerPadding), sampleItems)
                }
            }
        }
    }
}


@Composable
fun SearchBLE(modifier: Modifier = Modifier, items: List<MyCardItem>) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
        ) {
            DynamicCardList(items)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { ScanBLEButtons() }
    }
}

@Composable
fun ScanBLEButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
    ) {
        Card { Text("Start Scan") }
        Card { Text("Stop Scan") }
    }
}

@Composable
fun DynamicCardList(items: List<MyCardItem>) {
    LazyColumn {
        items(items) { item ->
            MyCard(item = item)
        }
    }
}

@Composable
fun MyCard(item: MyCardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Column {
                Text(text = item.title)
                Text(text = item.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDynamicCardList() {
    val sampleItems = listOf(
        MyCardItem("Title 1", "Description 1", R.drawable.ic_menu_gallery),
        MyCardItem("Title 2", "Description 2", R.drawable.ic_menu_camera),
        MyCardItem("Title 3", "Description 3", R.drawable.ic_menu_compass)
    )
    SearchBLE(modifier = Modifier, items = sampleItems)
}