package com.example.bluetoohlowenergyapp.domain.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {

    val isConnected: StateFlow<Boolean>

    val scannedDevices: StateFlow<List<BluetoothDevice>>

    val pairedDevices: StateFlow<List<BluetoothDevice>>

    val errors: SharedFlow<String>

    fun startDiscovery()

    fun stopDiscovery()

    fun release()

    fun connectToDevice(device: BluetoothDevice): Flow<ConnectionResult>

    fun closeConnection()
}