@file:Suppress("UNUSED_EXPRESSION")

package com.example.unitconverter

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.time.times
import androidx.compose.material3.Text as Text1


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                }
            }
            UnitConverter()
        }
    }
}
@Composable
fun UnitConverter()
{
    var outputvlue by remember { mutableStateOf("") }
    var inputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("centimeter") }
    var outputunit by remember {  mutableStateOf("meter") }
    var inexpand by remember { mutableStateOf(false) }
    var outexapand by remember {  mutableStateOf(false) }
    var infactor by remember { mutableStateOf(0.01) }
    var outfactor by remember { mutableStateOf(1.0) }
    
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
    Text1(text = "Unit Converter", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
       OutlinedTextField(value = inputvalue, onValueChange = {
           inputvalue=it
       } ,
         label = { Text1(text = "ENTER VALUE") }  )
        Spacer(modifier = Modifier.height(16.dp))
     Row {
         //input box
         Box {
             Button(onClick = { inexpand=true }) {
                 Text1(text = "select")
                 Icon(Icons.Default.ArrowDropDown,
                     contentDescription = "Arrow down")
             }
             DropdownMenu(expanded = inexpand, onDismissRequest = { inexpand=false }) {
                 DropdownMenuItem(text = { Text1(text = "milimeter") },
                     onClick = { 
                         inputunit="milimeter"
                         infactor=0.001
                         inexpand=false
                     }
                 )
                 DropdownMenuItem(text = { Text1(text ="cemimeter" ) },
                     onClick = { inputunit="centimetr"
                                infactor=0.01
                         inexpand=false}
                 )
                 DropdownMenuItem(text = { Text1(text ="meter" ) },
                     onClick = { inputunit="meter"
                     infactor=1.0
                         inexpand=false}
                 )
                 DropdownMenuItem(text = { Text1(text ="kilometer" ) },
                     onClick = {inputunit="kilometer"
                         infactor=1000.0
                         inexpand=false
                     }
                 )

             }
         }
         Spacer(modifier = Modifier.width(20.dp))
         //output box
         Box {
             Button(onClick = { outexapand=true }) {
                 Text1(text = "select")
                 Icon(Icons.Default.ArrowDropDown,
                     contentDescription = "Arrow down")
             }
             DropdownMenu(expanded =outexapand, onDismissRequest = { outexapand=false}) {
                 DropdownMenuItem(text = { Text1(text ="milimeter" ) },
                     onClick = { outputunit="milimeter"
                                outfactor=0.001
                            var x = inputvalue.toDouble()
                            var out= x*(infactor)/(outfactor)
                         outputvlue= out.toString()
                         outexapand=false
                     }
                 )
                 DropdownMenuItem(text = { Text1(text ="centimeter" ) },
                     onClick = {  outputunit="cemimeter"
                         outfactor=0.01
                         var x = inputvalue.toDouble()
                         var out= x*(infactor)/(outfactor)
                         outputvlue= out.toString()
                         outexapand=false
                     }
                 )
                 DropdownMenuItem(text = { Text1(text ="meter" ) },
                     onClick = {  outputunit="meter"
                         outfactor=1.0
                         var x = inputvalue.toDouble()
                         var out= x*(infactor)/(outfactor)
                         outputvlue= out.toString()
                         outexapand=false
                     }
                 )
                 DropdownMenuItem(text = { Text1(text ="kilometer" ) },
                     onClick = {  outputunit="kilometer"
                         outfactor=1000.0
                         var x = inputvalue.toDouble()
                         var out= x*(infactor)/(outfactor)
                         outputvlue= out.toString()
                         outexapand=false
                     }
                 )

             }
         }
     }
        Spacer(modifier = Modifier.height(30.dp))
        Box {
            Text1(text = "REASULT: $outputvlue $outputunit", style = MaterialTheme.typography.titleMedium
            )
        }

    }

    
}
@Preview( showBackground = true)
@Composable
fun UnitConverterPreview()
{
    UnitConverter()
}




