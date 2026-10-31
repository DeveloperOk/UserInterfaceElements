package com.enterprise.userinterfaceelements.presentation.view.components.text


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import com.enterprise.userinterfaceelements.R


@Composable
fun AppSimpleText(){

    Text(text = stringResource(R.string.text_screen_simple_text))

}

@Composable
fun AppWrapText(){

    Text(text = stringResource(R.string.text_screen_wrap_text))

}

@Composable
fun AppOverflowText(){

    Text(
        text = stringResource(R.string.text_screen_overflow_text),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

}


@Composable
fun AnnotatedText(){

    val annotatedText = buildAnnotatedString {
        pushStyle(SpanStyle(fontWeight = FontWeight.Normal, color = Color.Black))
        append(stringResource(id = R.string.text_screen_annotated_text_number))
        pop()
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black))
        append(stringResource(id = R.string.text_screen_annotated_text_annotated))
        pop()
        pushStyle(SpanStyle(color = Color.LightGray))
        append(stringResource(id = R.string.text_screen_annotated_text_text))
        pop()
    }

    Text(text = annotatedText)

}

@Composable
fun AppClickablePartsText() {
    val annotatedText = buildAnnotatedString {
        append("5) Clickable Text: ")

        withLink(
            LinkAnnotation.Url(
                "https://google.com",
                TextLinkStyles(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        ) {
            append("Google")
        }

        append(" and ")

        withLink(
            LinkAnnotation.Url(
                "https://yandex.com.tr",
                TextLinkStyles(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        ) {
            append("Yandex")
        }
    }

    Text(
        text = annotatedText,
        color = Color.Black
    )
}