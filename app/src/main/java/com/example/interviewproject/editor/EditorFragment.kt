package com.example.interviewproject.editor

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import com.example.interviewproject.ui.theme.composeView
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class EditorFragment : DialogFragment() {

    var onDismissed: (() -> Unit)? = null

    private val viewModel by stateViewModel<EditorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = composeView {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text("Time")

            Spacer(modifier = Modifier.height(4.dp))

            TextField(value = "12:00", onValueChange = {/*TODO*/ }, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(8.dp))

            val days = listOf("M", "T", "W", "T", "F", "S", "S")

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                days.forEach { day ->
                    ToggleDayButton(onClick = { /*TODO*/ }, day = day, selected = false/*TODO:*/)
                }
            }

            Button(onClick = { dismiss() }, modifier = Modifier.align(Alignment.End)) {
                Text("OK")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.toString()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        this.onDismissed?.invoke()
    }
}

@Composable
private fun ToggleDayButton(onClick: () -> Unit, day: String, selected: Boolean) {
    Text(
        text = day,
        color = if (selected) MaterialTheme.colors.secondary else LocalContentColor.current,
        modifier = Modifier
            .defaultMinSize(40.dp, 40.dp)
            .clickable(onClick = onClick)
            .wrapContentSize(Alignment.Center)
    )
}