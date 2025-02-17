package com.vlohachov.moviespot.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vlohachov.moviespot.R
import com.vlohachov.moviespot.core.LoremIpsum
import com.vlohachov.shared.ui.component.section.Section
import com.vlohachov.shared.ui.component.section.SectionDefaults
import com.vlohachov.shared.ui.component.section.SectionTitle
import com.vlohachov.shared.ui.theme.MoviesPotTheme

@Composable
fun Overview(
    text: String,
    modifier: Modifier = Modifier,
) {
    Section(
        modifier = modifier.semantics { testTag = OverviewDefaults.TestTag },
        title = {
            SectionTitle(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.overview),
            )
        },
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        textStyles = SectionDefaults.smallTextStyles(
            contentTextStyle = MaterialTheme.typography.bodyMedium,
        ),
    ) {
        Text(
            text = text.ifBlank { stringResource(id = R.string.no_results) },
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewPreview() {
    MoviesPotTheme {
        Overview(
            text = LoremIpsum,
        )
    }
}

object OverviewDefaults {
    const val TestTag = "OverviewTestTag"
}
