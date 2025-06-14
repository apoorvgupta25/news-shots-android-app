package com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import com.apoorvgupta.capabilities.presentation.theme.xl14_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxs_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxxs_stroke_width
import com.apoorvgupta.capabilities.util.Constants
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
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(s_corner_radius),
            )
            .border(
                border = BorderStroke(
                    width = xxxs_stroke_width,
                    color = MaterialTheme.colorScheme.outline,
                ),
                shape = RoundedCornerShape(s_corner_radius),
            )
            .padding(all = m_surrounding_spacing)
            .heightIn(min = xl14_vertical_spacing)
            .height(intrinsicSize = IntrinsicSize.Max),
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(end = xxs_horizontal_spacing),
        ) {
            Text(
                text = newsShot.title,
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                text = newsShot.description,
                modifier = Modifier.padding(top = s_vertical_spacing),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

            Text(
                modifier = Modifier.padding(top = sl_vertical_spacing),
                text = newsShot.formattedDate,
                style = MaterialTheme.typography.bodySmall,
            )
        }

        Column(
            modifier = Modifier.weight(Constants.FULL_WEIGHT),
            horizontalAlignment = Alignment.End,
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(s_corner_radius)),
                model = "${Constants.IMAGE_BASE_URL}${newsShot.link}",
                contentDescription = "NewsShot image",
            )

            Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_outlined),
                contentDescription = EMPTY_STRING,
                modifier = Modifier
                    .noRippleClickable {
                        onBookmarkClick.invoke()
                    }
                    .size(l_icon_size),
            )
        }
    }
}
