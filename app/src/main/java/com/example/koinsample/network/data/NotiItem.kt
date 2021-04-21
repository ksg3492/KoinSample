package com.example.koinsample.network.data

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
<title>제2회 기상청 기후변화과학 통합 공모전</title>
<category>본청</category>
<description>※ 자세한 사항은 첨부파일을 확인하시기 바랍니다.</description>
<link>http://www.kma.go.kr/notify/notice/list.jsp?mode=view&bid=gongzi&num=1192856</link>
<pubDate>Tue Apr 20 15:33:03 KST 2021</pubDate>
 */

@Xml
data class NotiItem(
    @PropertyElement
    var title : String,
    @PropertyElement
    var category : String,
    @PropertyElement
    var description : String
)