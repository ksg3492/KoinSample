package com.example.koinsample.network.data

import com.tickaroo.tikxml.annotation.*

/**
 * @sample
    <rss version="2.0">
        <channel>
            <title>공지사항</title>
            <link>http://www.kma.go.kr/notify/notice/list.jsp</link>
            <description>공지사항</description>
            <language>ko</language>
            <lastBuildDate/>
            <item>
                <title>제2회 기상청 기후변화과학 통합 공모전</title>
                <category>본청</category>
                <description>※ 자세한 사항은 첨부파일을 확인하시기 바랍니다.</description>
                <link>http://www.kma.go.kr/notify/notice/list.jsp?mode=view&bid=gongzi&num=1192856</link>
                <pubDate>Tue Apr 20 15:33:03 KST 2021</pubDate>
            </item>
            <item>
                ...
            </item>
            <item>
            ...
            </item>
        </channel>
    </rss>
 *
 */

@Xml(name = "rss")
data class WeatherInfo(
    @Path("channel")
    @PropertyElement
    var title : String,

    @Path("channel")
    @PropertyElement
    var description : String,

    @Path("channel")
    @Element(name="item")
    val items: List<NotiItem>? = arrayListOf()
)