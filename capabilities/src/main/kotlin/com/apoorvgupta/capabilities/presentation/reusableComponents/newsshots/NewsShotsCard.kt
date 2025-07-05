package com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots

import androidx.compose.foundation.background
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
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.core.utils.emptyValue
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
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(Dimensions.CornerRadius.s_corner_radius),
            )
            .padding(all = Dimensions.SurroundingDimensions.s_surrounding_spacing)
            .heightIn(min = Dimensions.VerticalDimensions.xl14_vertical_spacing)
            .height(intrinsicSize = IntrinsicSize.Max),
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(end = Dimensions.HorizonalDimensions.s_horizontal_spacing),
        ) {
            Text(
                text = newsShot.title,
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                text = newsShot.description,
                modifier = Modifier.padding(top = Dimensions.VerticalDimensions.s_vertical_spacing),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

            Text(
                modifier = Modifier.padding(top = Dimensions.VerticalDimensions.sl_vertical_spacing),
                text = newsShot.formattedDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier.weight(Constants.FULL_WEIGHT),
            horizontalAlignment = Alignment.End,
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(Dimensions.CornerRadius.s_corner_radius))
                    .heightIn(max = Dimensions.VerticalDimensions.xl11_vertical_spacing),
                model = "${Constants.IMAGE_BASE_URL}${newsShot.link}",
                contentDescription = "NewsShot image",
            )

            Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_outlined),
                contentDescription = String.emptyValue(),
                modifier = Modifier
                    .noRippleClickable {
                        onBookmarkClick.invoke()
                    }
                    .size(Dimensions.IconSize.l_icon_size),
            )
        }
    }
}
