package com.example.bluetoohlowenergyapp.domain.chat

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevices: StateFlow<List<BluetoothDevice>>

    val pairedDevices: StateFlow<List<BluetoothDevice>>

    fun startDiscovery()

    fun stopDiscovery()

    fun release()
}