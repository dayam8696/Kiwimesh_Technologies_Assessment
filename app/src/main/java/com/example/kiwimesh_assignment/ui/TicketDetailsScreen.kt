package com.example.kiwimesh_assignment.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.kiwimesh_assignment.R

@Composable
fun TicketDetailsScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding() // Adds padding for status bar and other system UI
    ) {
        // Blue background header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .background(
                    color = Color(0xFF007BFF),
                    shape = RoundedCornerShape(bottomStart = 27.dp, bottomEnd = 27.dp)
                )
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /* Handle back */ },
                    modifier = Modifier.offset(x = (-9).dp)) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Text(
                    text = "Enter Ticket Details",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "August 16, 2023 · 4:08 PM",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "DL1PC7195",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        // White card overlapping the blue background
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .offset(y = 160.dp)
                .zIndex(1f)
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.DirectionsBus,
                        contentDescription = "Bus",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFF49E01), RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "433 CL",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(text = "towards ", color = Color.Gray)
                    Text(
                        text = "New Delhi Railway Station",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Inputs below the card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 280.dp, start = 24.dp, end = 24.dp)
        ) {
            Row(verticalAlignment = Alignment.Top) {
                // Left: icons and dotted line
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(top = 6.dp, end = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = "Source Marker",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(vertical = 12.dp)
                    ) {
                        repeat(3) {
                            Box(
                                modifier = Modifier
                                    .size(4.dp)
                                    .background(Color.Gray, shape = RoundedCornerShape(50))
                            )
                        }
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = "Destination Marker",
                        tint = Color(0xFF007BFF),
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Right: input fields
                Column(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Enter Source Stop") },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Enter Destination Stop") },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            NumberOfTicketsSection()

            var isFavorite by remember { mutableStateOf(true) }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 1.dp)
            ) {
                Checkbox(
                    checked = isFavorite,
                    onCheckedChange = { isFavorite = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF007BFF)
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Add this bus route to your favorites.",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            FareSummaryCard(fare = 0.0, quantity = 0)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 28.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = { /* Handle action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .height(46.dp)
                ) {
                    Text(
                        text = "Pay ₹0.00",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun NumberOfTicketsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 1.dp, top = 16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .border(width = 1.dp, color = Color(0xFFB0B0B0), shape = RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Number of Tickets",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Maximum upto 3 tickets",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "--", fontSize = 22.sp, color = Color.Gray)

                    Spacer(modifier = Modifier.width(12.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Person Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(0.dp))

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(text = "0", fontSize = 16.sp, color = Color.Black)
                    }

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(text = "+", fontSize = 22.sp, color = Color(0xFF007BFF))
                }
            }
        }
    }
}

@Composable
fun FareSummaryCard(
    fare: Double = 0.0,
    discountPercent: Int = 10,
    quantity: Int = 0
) {
    val discountAmount = fare * quantity * discountPercent / 100
    val totalAmount = fare * quantity - discountAmount

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FB)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Ticket Fare x $quantity", style = MaterialTheme.typography.bodyMedium)
                Text("₹%.2f".format(fare * quantity))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("10% Discount", color = Color(0xFF388E3C), style = MaterialTheme.typography.bodyMedium)
                Text("- ₹%.2f".format(discountAmount), color = Color(0xFF388E3C))
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total Amount",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "₹%.2f".format(totalAmount),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicketDetailsScreenPreview() {
    TicketDetailsScreen()
}