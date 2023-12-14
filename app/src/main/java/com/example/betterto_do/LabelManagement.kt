//package com.example.betterto_do
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.icons.outlined.Check
//import androidx.compose.material.icons.outlined.Close
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.platform.LocalView
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.interaction.PressInteraction
//import androidx.compose.foundation.interaction.collectIsPressedAsState
//import androidx.compose.foundation.interaction.pressIndicatorGestureFilter
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.*
//import androidx.compose.material3.icons.Icons
//import androidx.compose.material3.icons.filled.Add
//import androidx.compose.material3.icons.filled.Save
//import androidx.compose.material3.icons.outlined.Cancel
//import androidx.compose.material3.icons.outlined.Edit
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//
//@Composable
//fun LabelManagementScreen(
//    labels: MutableState<List<String>>,
//    onLabelSelected: (String) -> Unit
//) {
//    var editingLabel by remember { mutableStateOf<String?>(null) }
//    var newLabel by remember { mutableStateOf("") }
//
//    val interactionSource = remember { MutableInteractionSource() }
//    val pressedState = interactionSource.collectIsPressedAsState()
//
//    DisposableEffect(pressedState.value) {
//        if (pressedState.value) {
//            // Handle the pressed state
//        }
//        onDispose { }
//    }
//
//    LazyColumn {
//        items(labels.value) { label ->
//            LabelItem(
//                label = label,
//                onEditClick = { editingLabel = label },
//                onDeleteClick = { updatedLabels ->
//                    labels.value = updatedLabels
//                },
//                onLabelClick = { onLabelSelected(it) }
//            )
//        }
//
//        if (editingLabel == null) {
//            AddNewLabelRow(
//                onAddClick = {
//                    if (newLabel.isNotBlank() && !labels.value.contains(newLabel)) {
//                        labels.value = labels.value + newLabel
//                        newLabel = ""
//                    }
//                },
//                onLabelChange = { newLabel = it }
//            )
//        } else {
//            EditLabelRow(
//                label = editingLabel!!,
//                onEditComplete = {
//                    editingLabel = null
//                }
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun LabelItem(
//    label: String,
//    onEditClick: () -> Unit,
//    onDeleteClick: (List<String>) -> Unit,
//    onLabelClick: (String) -> Unit
//) {
//    var isConfirmDeleteDialogVisible by remember { mutableStateOf(false) }
//    val view by rememberUpdatedState(label)
//    var isEditing by remember { mutableStateOf(false) }
//    var editedLabel by remember { mutableStateOf(label) }
//    val keyboardController = LocalSoftwareKeyboardController.current
//    val viewRef = LocalView.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(MaterialTheme.colorScheme.primary)
//            .padding(8.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = editedLabel,
//                modifier = Modifier
//                    .weight(1f)
//                    .clickable {
//                        if (!isEditing) {
//                            onLabelClick(editedLabel)
//                        }
//                    }
//                    .padding(8.dp)
//            )
//
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(4.dp)
//            ) {
//                if (isEditing) {
//                    IconButton(
//                        onClick = {
//                            isConfirmDeleteDialogVisible = true
//                        },
//                        modifier = Modifier.size(24.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Delete,
//                            contentDescription = stringResource(id = R.string.delete),
//                            tint = Color.Red
//                        )
//                    }
//                } else {
//                    IconButton(
//                        onClick = onEditClick,
//                        modifier = Modifier.size(24.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Edit,
//                            contentDescription = stringResource(id = R.string.edit)
//                        )
//                    }
//                }
//            }
//        }
//
//        if (isEditing) {
//            EditLabelRow(
//                label = editedLabel,
//                onEditComplete = {
//                    editedLabel = it
//                    isEditing = false
//                }
//            )
//        }
//
//        if (isConfirmDeleteDialogVisible) {
//            ConfirmDeleteDialog(
//                onConfirm = {
//                    onDeleteClick(labels.value - editedLabel)
//                    isConfirmDeleteDialogVisible = false
//                },
//                onDismiss = {
//                    isConfirmDeleteDialogVisible = false
//                }
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddNewLabelRow(
//    onAddClick: () -> Unit,
//    onLabelChange: (String) -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        OutlinedTextField(
//            value = "",
//            onValueChange = onLabelChange,
//            label = { Text(stringResource(id = R.string.new_label)) },
//            modifier = Modifier
//                .weight(1f)
//                .padding(8.dp)
//        )
//
//        IconButton(
//            onClick = onAddClick,
//            modifier = Modifier.size(24.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = stringResource(id = R.string.add)
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
//@Composable
//fun EditLabelRow(
//    label: String,
//    onEditComplete: () -> Unit
//) {
//    var editedLabel by remember { mutableStateOf(label) }
//    val keyboardController = LocalSoftwareKeyboardController.current
//    val viewRef = LocalView.current
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        OutlinedTextField(
//            value = editedLabel,
//            onValueChange = { editedLabel = it },
//            label = { Text(stringResource(id = R.string.edit_label)) },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Done
//            ),
//            keyboardActions = KeyboardActions(
//                onDone = {
//                    keyboardController?.hide()
//                    onEditComplete()
//                }
//            ),
//            modifier = Modifier
//                .weight(1f)
//                .padding(8.dp)
//        )
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//            IconButton(
//                onClick = {
//                    onEditComplete()
//                    keyboardController?.hide()
//                },
//                modifier = Modifier.size(24.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Close,
//                    contentDescription = stringResource(id = R.string.cancel)
//                )
//            }
//
//            IconButton(
//                onClick = {
//                    onEditComplete()
//                    keyboardController?.hide()
//                },
//                modifier = Modifier.size(24.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Check,
//                    contentDescription = stringResource(id = R.string.save)
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun ConfirmDeleteDialog(
//    onConfirm: () -> Unit,
//    onDismiss: () -> Unit
//) {
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        title = { Text(stringResource(id = R.string.confirm_delete_title)) },
//        text = { Text(stringResource(id = R.string.confirm_delete_message)) },
//        confirmButton = {
//            Button(
//                onClick = {
//                    onConfirm()
//                    onDismiss()
//                }
//            ) {
//                Text(stringResource(id = R.string.confirm))
//            }
//        },
//        dismissButton = {
//            Button(
//                onClick = onDismiss
//            ) {
//                Text(stringResource(id = R.string.cancel))
//            }
//        }
//    )
//}