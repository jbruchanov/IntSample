package com.example.interviewproject.items

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.interviewproject.editor.EditorFragment
import com.example.interviewproject.model.Alarm
import com.example.interviewproject.ui.theme.composeView

class ItemsFragment : Fragment() {

    private val viewModel by viewModels<ItemsViewModel>()

    init {
        Log.d("ItemsFragment", "Created")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = composeView {
        Column {
            Row {
                IconButton(onClick = { openEditor() }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }

                Spacer(modifier = Modifier.width(4.dp))

                IconButton(onClick = { /*TODO*/ } /*TODO: invisible if nothing selected*/) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(onClick = { /*TODO*/ } /*TODO: pregenerate 3 random items */) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "Generate")
                }
            }

            AlarmRow(
                onClick = {/*TODO*/ },
                onEditClick = {/*TODO*/ },
                onCheckedChange = { /*TODO*/ },
                alarm = Alarm(),
                selected = false
            )
        }
    }


    private fun openEditor() {
        EditorFragment().apply {
            onDismissed = {
                /*TODO: reload */
            }
        }.show(parentFragmentManager, "EditorFragment")
    }
}

@Composable
private fun AlarmRow(
    onClick: () -> Unit,
    onEditClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    alarm: Alarm,
    selected: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(if (selected) Color.White.copy(alpha = 0.1f) else Color.Transparent)
            .padding(6.dp)
    ) {
        IconButton(onClick = { onEditClick }, modifier = Modifier) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
        }

        Column {
            Text("Time: ${alarm.time}")
            Text("Days: ${alarm.days()}")
        }

        Switch(alarm.enabled, onCheckedChange = onCheckedChange)
    }
}