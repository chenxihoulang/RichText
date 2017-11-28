package com.example.chaihongwei.richtext;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv9 = findViewById(R.id.tv9);
        tv10 = findViewById(R.id.tv10);
        tv11 = findViewById(R.id.tv11);
        tv12 = findViewById(R.id.tv12);
        tv13 = findViewById(R.id.tv13);
        tv14 = findViewById(R.id.tv14);

        //设置Hello World前三个字符为红色,背景为蓝色
        SpannableString textSpanned1 = new SpannableString("1Hello World");
        textSpanned1.setSpan(new ForegroundColorSpan(Color.RED),
                0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textSpanned1.setSpan(new BackgroundColorSpan(Color.BLUE),
                0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv1.setText(textSpanned1);

        //设置Hello World前三个字符字体为斜体
        SpannableString textSpanned2 = new SpannableString("2Hello World");
        textSpanned2.setSpan(new StyleSpan(Typeface.ITALIC),
                0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv2.setText(textSpanned2);

        //设置Hello World前三个字符有下划线
        SpannableString textSpanned3 = new SpannableString("3Hello World");
        textSpanned3.setSpan(new UnderlineSpan(),
                0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv3.setText(textSpanned3);

        //设置Hello World前三个字符有点击事件
        SpannableStringBuilder textSpanned4 = new SpannableStringBuilder("4Hello World\naaa\n\nsafsadfsafsda");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "4Hello World\naaa\n\nsafsadfsafsda", Toast.LENGTH_SHORT).show();
            }
        };
        textSpanned4.setSpan(clickableSpan,
                0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //注意：此时必须加这一句，不然点击事件不会生效
        tv4.setMovementMethod(ClickableMovementMethod.getInstance());
        tv4.setText(textSpanned4);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "4Click", Toast.LENGTH_SHORT).show();
            }
        });


        //Spanned.SPAN_EXCLUSIVE_EXCLUSIVE	前后都不包括
        SpannableStringBuilder textSpannedBuilder1 = new SpannableStringBuilder();
        SpannableString textSpanned11 = new SpannableString("5Hello");
        textSpanned11.setSpan(new BackgroundColorSpan(Color.BLUE), 0, textSpanned11.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableString textSpanned12 = new SpannableString("World");
        tv5.setText(textSpannedBuilder1.append(textSpanned11).append(textSpanned12));

        //Spanned.SPAN_EXCLUSIVE_INCLUSIVE	前面不包括，后面包括
        SpannableStringBuilder textSpannedBuilder2 = new SpannableStringBuilder();
        SpannableString textSpanned21 = new SpannableString("6Hello");
        textSpanned21.setSpan(new BackgroundColorSpan(Color.BLUE), 0, textSpanned21.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SpannableString textSpanned22 = new SpannableString("World");
        tv6.setText(textSpannedBuilder2.append(textSpanned21).insert(0,"a").append(textSpanned22));


        SpannableStringBuilder textSpannedBuilder3 = new SpannableStringBuilder();
        SpannableString textSpanned31 = new SpannableString("7Hello");
        textSpanned31.setSpan(new BackgroundColorSpan(Color.BLUE), 0, textSpanned31.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SpannableString textSpanned32 = new SpannableString("World");
        textSpanned32.setSpan(new BackgroundColorSpan(Color.GREEN), 0, 3,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv7.setText(textSpannedBuilder3.append(textSpanned31).append(textSpanned32));


        String htmlText1 = "<b>Hello World</b>";
        tv8.setText(Html.fromHtml(htmlText1));

        String htmlText2 = "<font color='#ff0000'>Hello World</font>";
        tv9.setText(Html.fromHtml(htmlText2));

        String htmlText3 = "<i><a href='https://gavinli369.github.io/'>我的博客</a></i>";
        tv10.setMovementMethod(LinkMovementMethod.getInstance());
        tv10.setText(Html.fromHtml(htmlText3));

        String htmlText4 = "<i><a href='https://gavinli369.github.io/'>我的博客</a><img src='ic_launcher'/></i>";
        tv11.setMovementMethod(LinkMovementMethod.getInstance());
        tv11.setText(Html.fromHtml(htmlText4, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                if ("ic_launcher".equals(source)) {
                    Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);

                    //必须加上,否则图片不显示
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                            .getIntrinsicHeight());
                }

                return null;
            }
        }, null));


        String url = "This is a page with lots of URLs. <a href=\"http://droidyue.com\">droidyue.com</> " +
                "This left is a very good blog. There are so many great blogs there. You can find what" +
                "you want in that blog."
                + "The Next Link is <a href=\"http://www.google.com.hk\">Google HK</a>";
        tv12.setText(getClickableHtml(url));

        final String username = "晨曦";
        final String replyUserName = "后浪";
        String content = "你走开……";
        SpannableString spannableString = getLinkSpannableString(username);
        SpannableString spannableString1 = getLinkSpannableString(replyUserName);

        Spanned replyText = Html.fromHtml("<font color=" + getResources().getColor(R.color.deep_gray) + ">回复</font>");
        Spanned colon = Html.fromHtml("<font color=" + getResources().getColor(R.color.link_color) + ">：</font>");
        Spanned body = Html.fromHtml("<font color=" + getResources().getColor(R.color.text_color) + ">" + content + "</font>");
        Spanned richText = (Spanned) android.text.TextUtils.concat(spannableString, replyText, spannableString1, colon, body);
        tv13.setText(richText);
        tv13.setMovementMethod(LinkMovementMethod.getInstance());


        String string = "xx&xx\rsssss\nddddd";
        tv14.setText(Html.fromHtml(
                string.replace("\r\n", "<br/>")
                        .replace("\n", "<br/>")
                        .replace("\r", "<br/>")));
    }

    @NonNull
    private SpannableString getLinkSpannableString(final String username) {
        SpannableString spannableString = new SpannableString(username);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, username, Toast.LENGTH_LONG).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getResources().getColor(R.color.link_color));
                ds.setUnderlineText(false);
            }
        };
        spannableString.setSpan(span, 0, username.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return spannableString;
    }

    private void setLinkClickable(final SpannableStringBuilder clickableHtmlBuilder,
                                  final URLSpan urlSpan) {
        int start = clickableHtmlBuilder.getSpanStart(urlSpan);
        int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
        int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //Do something with URL here.
                Toast.makeText(MainActivity.this, urlSpan.getURL(), Toast.LENGTH_LONG).show();
            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
    }

    private CharSequence getClickableHtml(String html) {
        Spanned spannedHtml = Html.fromHtml(html);
        SpannableStringBuilder clickableHtmlBuilder = new SpannableStringBuilder(spannedHtml);
        URLSpan[] urls = clickableHtmlBuilder.getSpans(0, spannedHtml.length(), URLSpan.class);
        for (final URLSpan span : urls) {
            setLinkClickable(clickableHtmlBuilder, span);
        }
        return clickableHtmlBuilder;
    }
}
