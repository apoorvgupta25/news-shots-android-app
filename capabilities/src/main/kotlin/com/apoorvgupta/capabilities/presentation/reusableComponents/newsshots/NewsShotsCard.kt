package com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.presentation.reusableComponents.noRippleClickable
import com.apoorvgupta.capabilities.presentation.theme.l_icon_size
import com.apoorvgupta.capabilities.presentation.theme.m_surrounding_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_corner_radius
import com.apoorvgupta.capabilities.presentation.theme.s_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.sl_vertical_spacing
import com.apoorvgupta.core.utils.EMPTY_STRING
import com.apoorvgupta.newsshots.capabilities.R

/**
 * @author Apoorv Gupta
 */

@Composable
fun NewsShotsCard(
    newsShot: NewsShots,
    onCardClick: () -> Unit,
    onBookmarkClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .noRippleClickable {
                onCardClick()
            }
            .fillMaxWidth()
            .padding(bottom = m_vertical_spacing)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(s_corner_radius),
            )
            .padding(all = m_surrounding_spacing)
            .height(intrinsicSize = IntrinsicSize.Max),
    ) {
        Column(
            modifier = Modifier.weight(2f),
        ) {
            Text(
                text = newsShot.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            )

            Text(
                text = newsShot.description,
                modifier = Modifier.padding(top = s_vertical_spacing),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                modifier = Modifier.padding(top = sl_vertical_spacing),
                text = newsShot.formattedDate,
                style = MaterialTheme.typography.bodySmall,
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End,
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(s_corner_radius)),
                model = "https://news-shots-backend.onrender.com/api/daily/photo/${newsShot.link}",
                contentDescription = "NewsShot image",
            )

            Spacer(modifier = Modifier.weight(1F))

            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_outlined),
                contentDescription = EMPTY_STRING,
                modifier = Modifier
                    .noRippleClickable {
                        onBookmarkClick
                    }
                    .size(l_icon_size),
            )
        }
    }
}
