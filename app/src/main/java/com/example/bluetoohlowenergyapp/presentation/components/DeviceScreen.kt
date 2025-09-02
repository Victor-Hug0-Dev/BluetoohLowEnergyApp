package com.example.bluetoohlowenergyapp.presentation.components

import android.R
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bluetoohlowenergyapp.domain.chat.BluetoothDevice
import com.example.bluetoohlowenergyapp.presentation.BluetoothUIState

@Composable
fun SearchBLE(
    state: BluetoothUIState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
    modifier: Modifier = Modifier
) {

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
            DynamicCardList(state.scannedDevices)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { ScanBLEButtons(onStartScan, onStopScan) }
    }
}

@Composable
fun ScanBLEButtons(
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
    ) {
        Button(onClick = onStartScan) {
            Text("Start Scan")
        }
        Button(onClick = onStopScan) {
            Text("Stop Scan")
        }
    }
}

@Composable
fun DynamicCardList(scannedDevices: List<BluetoothDevice>) {
    LazyColumn {
        items(scannedDevices) { device ->
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
                        painter = painterResource(id = R.drawable.ic_menu_compass),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Column {
                        Text(text = device.name ?: "Unknown")
                        Text(text = device.address)
                    }
                }
            }
        }
    }
}

