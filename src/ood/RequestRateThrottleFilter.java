



<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
 
 <meta name="ROBOTS" content="NOARCHIVE">
 
 <link rel="icon" type="image/vnd.microsoft.icon" href="https://ssl.gstatic.com/codesite/ph/images/phosting.ico">
 
 
 <script type="text/javascript">
 
 
 
 
 var codesite_token = "ABZ6GAfUTjQ5uk7arEixzVWCHxwTjfbm0Q:1469229187937";
 
 
 var CS_env = {"domainName": null, "projectName": "owasp-esapi-java", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/10034343235110290935", "token": "ABZ6GAfUTjQ5uk7arEixzVWCHxwTjfbm0Q:1469229187937", "profileUrl": "/u/113015210929330814047/", "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "loggedInUserEmail": "billyzhang2010@gmail.com", "relativeBaseUrl": "", "projectHomeUrl": "/p/owasp-esapi-java"};
 var _gaq = _gaq || [];
 _gaq.push(
 ['siteTracker._setAccount', 'UA-18071-1'],
 ['siteTracker._trackPageview']);
 
 _gaq.push(
 ['projectTracker._setAccount', 'UA-725452-3'],
 ['projectTracker._trackPageview']);
 
 (function() {
 var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
 ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
 (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
 })();
 
 </script>
 
 
 <title>RequestRateThrottleFilter.java - 
 owasp-esapi-java -
 
 
 OWASP Enterprise Security API (Java Edition) - Google Project Hosting
 </title>
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/10034343235110290935/css/core.css">
 
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/10034343235110290935/css/ph_detail.css" >
 
 
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/10034343235110290935/css/d_sb.css" >
 
 
 
<!--[if IE]>
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/10034343235110290935/css/d_ie.css" >
<![endif]-->
 <style type="text/css">
 .menuIcon.off { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -42px }
 .menuIcon.on { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -28px }
 .menuIcon.down { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 0; }
 
 
 
  tr.inline_comment {
 background: #fff;
 vertical-align: top;
 }
 div.draft, div.published {
 padding: .3em;
 border: 1px solid #999; 
 margin-bottom: .1em;
 font-family: arial, sans-serif;
 max-width: 60em;
 }
 div.draft {
 background: #ffa;
 } 
 div.published {
 background: #e5ecf9;
 }
 div.published .body, div.draft .body {
 padding: .5em .1em .1em .1em;
 max-width: 60em;
 white-space: pre-wrap;
 white-space: -moz-pre-wrap;
 white-space: -pre-wrap;
 white-space: -o-pre-wrap;
 word-wrap: break-word;
 font-size: 1em;
 }
 div.draft .actions {
 margin-left: 1em;
 font-size: 90%;
 }
 div.draft form {
 padding: .5em .5em .5em 0;
 }
 div.draft textarea, div.published textarea {
 width: 95%;
 height: 10em;
 font-family: arial, sans-serif;
 margin-bottom: .5em;
 }

 
 .nocursor, .nocursor td, .cursor_hidden, .cursor_hidden td {
 background-color: white;
 height: 2px;
 }
 .cursor, .cursor td {
 background-color: darkblue;
 height: 2px;
 display: '';
 }
 
 
.list {
 border: 1px solid white;
 border-bottom: 0;
}

 
 </style>
</head>
<body class="t4">
<script type="text/javascript">
 window.___gcfg = {lang: 'en'};
 (function() 
 {var po = document.createElement("script");
 po.type = "text/javascript"; po.async = true;po.src = "https://apis.google.com/js/plusone.js";
 var s = document.getElementsByTagName("script")[0];
 s.parentNode.insertBefore(po, s);
 })();
</script>
<div class="headbg">

 <div id="gaia">
 

 <span>
 
 
 
 <a href="#" id="multilogin-dropdown" onclick="return false;"
 ><u><b>billyzhang2010@gmail.com</b></u> <small>&#9660;</small></a>
 
 
 | <a href="/u/113015210929330814047/" id="projects-dropdown" onclick="return false;"
 ><u>My favorites</u> <small>&#9660;</small></a>
 | <a href="/u/113015210929330814047/" onclick="_CS_click('/gb/ph/profile');"
 title="Profile, Updates, and Settings"
 ><u>Profile</u></a>
 | <a href="https://www.google.com/accounts/Logout?continue=https%3A%2F%2Fcode.google.com%2Fp%2Fowasp-esapi-java%2Fsource%2Fbrowse%2Ftrunk%2Fsrc%2Fmain%2Fjava%2Forg%2Fowasp%2Fesapi%2Ffilters%2FRequestRateThrottleFilter.java" 
 onclick="_CS_click('/gb/ph/signout');"
 ><u>Sign out</u></a>
 
 </span>

 </div>

 <div class="gbh" style="left: 0pt;"></div>
 <div class="gbh" style="right: 0pt;"></div>
 
 
 <div style="height: 1px"></div>
<!--[if lte IE 7]>
<div style="text-align:center;">
Your version of Internet Explorer is not supported. Try a browser that
contributes to open source, such as <a href="http://www.firefox.com">Firefox</a>,
<a href="http://www.google.com/chrome">Google Chrome</a>, or
<a href="http://code.google.com/chrome/chromeframe/">Google Chrome Frame</a>.
</div>
<![endif]-->



 <table style="padding:0px; margin: 0px 0px 10px 0px; width:100%" cellpadding="0" cellspacing="0"
 itemscope itemtype="http://schema.org/CreativeWork">
 <tr style="height: 58px;">
 
 
 
 <td id="plogo">
 <link itemprop="url" href="/p/owasp-esapi-java">
 <a href="/p/owasp-esapi-java/">
 
 
 <img src="/p/owasp-esapi-java/logo?cct=1415899706"
 alt="Logo" itemprop="image">
 
 </a>
 </td>
 
 <td style="padding-left: 0.5em">
 
 <div id="pname">
 <a href="/p/owasp-esapi-java/"><span itemprop="name">owasp-esapi-java</span></a>
 </div>
 
 <div id="psum">
 <a id="project_summary_link"
 href="/p/owasp-esapi-java/"><span itemprop="description">OWASP Enterprise Security API (Java Edition)</span></a>
 
 </div>
 
 
 </td>
 <td style="white-space:nowrap;text-align:right; vertical-align:bottom;">
 
 <form action="/hosting/search">
 <input size="30" name="q" value="" type="text">
 
 <input type="submit" name="projectsearch" value="Search projects" >
 </form>
 
 </tr>
 </table>

</div>

 
<div id="mt" class="gtb"> 
 <a href="/p/owasp-esapi-java/" class="tab ">Project&nbsp;Home</a>
 
 
 
 
 <a href="/p/owasp-esapi-java/downloads/list" class="tab ">Downloads</a>
 
 
 
 
 
 <a href="/p/owasp-esapi-java/wiki/Welcome?tm=6" class="tab ">Wiki</a>
 
 
 
 
 
 <a href="/p/owasp-esapi-java/issues/list"
 class="tab ">Issues</a>
 
 
 
 
 
 <a href="/p/owasp-esapi-java/source/checkout"
 class="tab active">Source</a>
 
 
 
 
 
 
 
 
 <div class=gtbc></div>
</div>

 

<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 
 
 
 
 
 
 <td class="subt">
 <div class="st2">
 <div class="isf">
 
 


 <span class="inst1"><a href="/p/owasp-esapi-java/source/checkout">Checkout</a></span> &nbsp;
 <span class="inst2"><a href="/p/owasp-esapi-java/source/browse/">Browse</a></span> &nbsp;
 <span class="inst3"><a href="/p/owasp-esapi-java/source/list">Changes</a></span> &nbsp;
 
 
 
 
 
 
 
 </form>
 <script type="text/javascript">
 
 function codesearchQuery(form) {
 var query = document.getElementById('q').value;
 if (query) { form.action += '%20' + query; }
 }
 </script>
 </div>
</div>

 </td>
 
 
 
 <td align="right" valign="top" class="bevel-right"></td>
 </tr>
</table>


<script type="text/javascript">
 var cancelBubble = false;
 function _go(url) { document.location = url; }
</script>
<div id="maincol"
 
>

 




<div class="expand">
<div id="colcontrol">
<style type="text/css">
 #file_flipper { white-space: nowrap; padding-right: 2em; }
 #file_flipper.hidden { display: none; }
 #file_flipper .pagelink { color: #0000CC; text-decoration: underline; }
 #file_flipper #visiblefiles { padding-left: 0.5em; padding-right: 0.5em; }
</style>
<table id="nav_and_rev" class="list"
 cellpadding="0" cellspacing="0" width="100%">
 <tr>
 
 <td nowrap="nowrap" class="src_crumbs src_nav" width="33%">
 <strong class="src_nav">Source path:&nbsp;</strong>
 <span id="crumb_root">
 
 <a href="/p/owasp-esapi-java/source/browse/">svn</a>/&nbsp;</span>
 <span id="crumb_links" class="ifClosed"><a href="/p/owasp-esapi-java/source/browse/trunk/">trunk</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/">src</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/">main</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/">java</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/">org</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/">owasp</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/esapi/">esapi</a><span class="sp">/&nbsp;</span><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/esapi/filters/">filters</a><span class="sp">/&nbsp;</span>RequestRateThrottleFilter.java</span>
 
 


 </td>
 
 
 <td nowrap="nowrap" width="33%" align="right">
 <table cellpadding="0" cellspacing="0" style="font-size: 100%"><tr>
 
 
 <td class="flipper">
 <ul class="leftside">
 
 <li><a href="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java?r=574" title="Previous">&lsaquo;r574</a></li>
 
 </ul>
 </td>
 
 <td class="flipper"><b>r1961</b></td>
 
 </tr></table>
 </td> 
 </tr>
</table>

<div class="fc">
 
 
 
<style type="text/css">
.undermouse span {
 background-image: url(https://ssl.gstatic.com/codesite/ph/images/comments.gif); }
</style>
<table class="opened" id="review_comment_area"
onmouseout="gutterOut()"><tr>
<td id="nums">
<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>
<pre><table width="100%" id="nums_table_0"><tr id="gr_svn1961_1"

 onmouseover="gutterOver(1)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',1);">&nbsp;</span
></td><td id="1"><a href="#1">1</a></td></tr
><tr id="gr_svn1961_2"

 onmouseover="gutterOver(2)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',2);">&nbsp;</span
></td><td id="2"><a href="#2">2</a></td></tr
><tr id="gr_svn1961_3"

 onmouseover="gutterOver(3)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',3);">&nbsp;</span
></td><td id="3"><a href="#3">3</a></td></tr
><tr id="gr_svn1961_4"

 onmouseover="gutterOver(4)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',4);">&nbsp;</span
></td><td id="4"><a href="#4">4</a></td></tr
><tr id="gr_svn1961_5"

 onmouseover="gutterOver(5)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',5);">&nbsp;</span
></td><td id="5"><a href="#5">5</a></td></tr
><tr id="gr_svn1961_6"

 onmouseover="gutterOver(6)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',6);">&nbsp;</span
></td><td id="6"><a href="#6">6</a></td></tr
><tr id="gr_svn1961_7"

 onmouseover="gutterOver(7)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',7);">&nbsp;</span
></td><td id="7"><a href="#7">7</a></td></tr
><tr id="gr_svn1961_8"

 onmouseover="gutterOver(8)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',8);">&nbsp;</span
></td><td id="8"><a href="#8">8</a></td></tr
><tr id="gr_svn1961_9"

 onmouseover="gutterOver(9)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',9);">&nbsp;</span
></td><td id="9"><a href="#9">9</a></td></tr
><tr id="gr_svn1961_10"

 onmouseover="gutterOver(10)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',10);">&nbsp;</span
></td><td id="10"><a href="#10">10</a></td></tr
><tr id="gr_svn1961_11"

 onmouseover="gutterOver(11)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',11);">&nbsp;</span
></td><td id="11"><a href="#11">11</a></td></tr
><tr id="gr_svn1961_12"

 onmouseover="gutterOver(12)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',12);">&nbsp;</span
></td><td id="12"><a href="#12">12</a></td></tr
><tr id="gr_svn1961_13"

 onmouseover="gutterOver(13)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',13);">&nbsp;</span
></td><td id="13"><a href="#13">13</a></td></tr
><tr id="gr_svn1961_14"

 onmouseover="gutterOver(14)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',14);">&nbsp;</span
></td><td id="14"><a href="#14">14</a></td></tr
><tr id="gr_svn1961_15"

 onmouseover="gutterOver(15)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',15);">&nbsp;</span
></td><td id="15"><a href="#15">15</a></td></tr
><tr id="gr_svn1961_16"

 onmouseover="gutterOver(16)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',16);">&nbsp;</span
></td><td id="16"><a href="#16">16</a></td></tr
><tr id="gr_svn1961_17"

 onmouseover="gutterOver(17)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',17);">&nbsp;</span
></td><td id="17"><a href="#17">17</a></td></tr
><tr id="gr_svn1961_18"

 onmouseover="gutterOver(18)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',18);">&nbsp;</span
></td><td id="18"><a href="#18">18</a></td></tr
><tr id="gr_svn1961_19"

 onmouseover="gutterOver(19)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',19);">&nbsp;</span
></td><td id="19"><a href="#19">19</a></td></tr
><tr id="gr_svn1961_20"

 onmouseover="gutterOver(20)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',20);">&nbsp;</span
></td><td id="20"><a href="#20">20</a></td></tr
><tr id="gr_svn1961_21"

 onmouseover="gutterOver(21)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',21);">&nbsp;</span
></td><td id="21"><a href="#21">21</a></td></tr
><tr id="gr_svn1961_22"

 onmouseover="gutterOver(22)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',22);">&nbsp;</span
></td><td id="22"><a href="#22">22</a></td></tr
><tr id="gr_svn1961_23"

 onmouseover="gutterOver(23)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',23);">&nbsp;</span
></td><td id="23"><a href="#23">23</a></td></tr
><tr id="gr_svn1961_24"

 onmouseover="gutterOver(24)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',24);">&nbsp;</span
></td><td id="24"><a href="#24">24</a></td></tr
><tr id="gr_svn1961_25"

 onmouseover="gutterOver(25)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',25);">&nbsp;</span
></td><td id="25"><a href="#25">25</a></td></tr
><tr id="gr_svn1961_26"

 onmouseover="gutterOver(26)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',26);">&nbsp;</span
></td><td id="26"><a href="#26">26</a></td></tr
><tr id="gr_svn1961_27"

 onmouseover="gutterOver(27)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',27);">&nbsp;</span
></td><td id="27"><a href="#27">27</a></td></tr
><tr id="gr_svn1961_28"

 onmouseover="gutterOver(28)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',28);">&nbsp;</span
></td><td id="28"><a href="#28">28</a></td></tr
><tr id="gr_svn1961_29"

 onmouseover="gutterOver(29)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',29);">&nbsp;</span
></td><td id="29"><a href="#29">29</a></td></tr
><tr id="gr_svn1961_30"

 onmouseover="gutterOver(30)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',30);">&nbsp;</span
></td><td id="30"><a href="#30">30</a></td></tr
><tr id="gr_svn1961_31"

 onmouseover="gutterOver(31)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',31);">&nbsp;</span
></td><td id="31"><a href="#31">31</a></td></tr
><tr id="gr_svn1961_32"

 onmouseover="gutterOver(32)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',32);">&nbsp;</span
></td><td id="32"><a href="#32">32</a></td></tr
><tr id="gr_svn1961_33"

 onmouseover="gutterOver(33)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',33);">&nbsp;</span
></td><td id="33"><a href="#33">33</a></td></tr
><tr id="gr_svn1961_34"

 onmouseover="gutterOver(34)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',34);">&nbsp;</span
></td><td id="34"><a href="#34">34</a></td></tr
><tr id="gr_svn1961_35"

 onmouseover="gutterOver(35)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',35);">&nbsp;</span
></td><td id="35"><a href="#35">35</a></td></tr
><tr id="gr_svn1961_36"

 onmouseover="gutterOver(36)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',36);">&nbsp;</span
></td><td id="36"><a href="#36">36</a></td></tr
><tr id="gr_svn1961_37"

 onmouseover="gutterOver(37)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',37);">&nbsp;</span
></td><td id="37"><a href="#37">37</a></td></tr
><tr id="gr_svn1961_38"

 onmouseover="gutterOver(38)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',38);">&nbsp;</span
></td><td id="38"><a href="#38">38</a></td></tr
><tr id="gr_svn1961_39"

 onmouseover="gutterOver(39)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',39);">&nbsp;</span
></td><td id="39"><a href="#39">39</a></td></tr
><tr id="gr_svn1961_40"

 onmouseover="gutterOver(40)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',40);">&nbsp;</span
></td><td id="40"><a href="#40">40</a></td></tr
><tr id="gr_svn1961_41"

 onmouseover="gutterOver(41)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',41);">&nbsp;</span
></td><td id="41"><a href="#41">41</a></td></tr
><tr id="gr_svn1961_42"

 onmouseover="gutterOver(42)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',42);">&nbsp;</span
></td><td id="42"><a href="#42">42</a></td></tr
><tr id="gr_svn1961_43"

 onmouseover="gutterOver(43)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',43);">&nbsp;</span
></td><td id="43"><a href="#43">43</a></td></tr
><tr id="gr_svn1961_44"

 onmouseover="gutterOver(44)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',44);">&nbsp;</span
></td><td id="44"><a href="#44">44</a></td></tr
><tr id="gr_svn1961_45"

 onmouseover="gutterOver(45)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',45);">&nbsp;</span
></td><td id="45"><a href="#45">45</a></td></tr
><tr id="gr_svn1961_46"

 onmouseover="gutterOver(46)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',46);">&nbsp;</span
></td><td id="46"><a href="#46">46</a></td></tr
><tr id="gr_svn1961_47"

 onmouseover="gutterOver(47)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',47);">&nbsp;</span
></td><td id="47"><a href="#47">47</a></td></tr
><tr id="gr_svn1961_48"

 onmouseover="gutterOver(48)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',48);">&nbsp;</span
></td><td id="48"><a href="#48">48</a></td></tr
><tr id="gr_svn1961_49"

 onmouseover="gutterOver(49)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',49);">&nbsp;</span
></td><td id="49"><a href="#49">49</a></td></tr
><tr id="gr_svn1961_50"

 onmouseover="gutterOver(50)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',50);">&nbsp;</span
></td><td id="50"><a href="#50">50</a></td></tr
><tr id="gr_svn1961_51"

 onmouseover="gutterOver(51)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',51);">&nbsp;</span
></td><td id="51"><a href="#51">51</a></td></tr
><tr id="gr_svn1961_52"

 onmouseover="gutterOver(52)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',52);">&nbsp;</span
></td><td id="52"><a href="#52">52</a></td></tr
><tr id="gr_svn1961_53"

 onmouseover="gutterOver(53)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',53);">&nbsp;</span
></td><td id="53"><a href="#53">53</a></td></tr
><tr id="gr_svn1961_54"

 onmouseover="gutterOver(54)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',54);">&nbsp;</span
></td><td id="54"><a href="#54">54</a></td></tr
><tr id="gr_svn1961_55"

 onmouseover="gutterOver(55)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',55);">&nbsp;</span
></td><td id="55"><a href="#55">55</a></td></tr
><tr id="gr_svn1961_56"

 onmouseover="gutterOver(56)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',56);">&nbsp;</span
></td><td id="56"><a href="#56">56</a></td></tr
><tr id="gr_svn1961_57"

 onmouseover="gutterOver(57)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',57);">&nbsp;</span
></td><td id="57"><a href="#57">57</a></td></tr
><tr id="gr_svn1961_58"

 onmouseover="gutterOver(58)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',58);">&nbsp;</span
></td><td id="58"><a href="#58">58</a></td></tr
><tr id="gr_svn1961_59"

 onmouseover="gutterOver(59)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',59);">&nbsp;</span
></td><td id="59"><a href="#59">59</a></td></tr
><tr id="gr_svn1961_60"

 onmouseover="gutterOver(60)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',60);">&nbsp;</span
></td><td id="60"><a href="#60">60</a></td></tr
><tr id="gr_svn1961_61"

 onmouseover="gutterOver(61)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',61);">&nbsp;</span
></td><td id="61"><a href="#61">61</a></td></tr
><tr id="gr_svn1961_62"

 onmouseover="gutterOver(62)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',62);">&nbsp;</span
></td><td id="62"><a href="#62">62</a></td></tr
><tr id="gr_svn1961_63"

 onmouseover="gutterOver(63)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',63);">&nbsp;</span
></td><td id="63"><a href="#63">63</a></td></tr
><tr id="gr_svn1961_64"

 onmouseover="gutterOver(64)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',64);">&nbsp;</span
></td><td id="64"><a href="#64">64</a></td></tr
><tr id="gr_svn1961_65"

 onmouseover="gutterOver(65)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',65);">&nbsp;</span
></td><td id="65"><a href="#65">65</a></td></tr
><tr id="gr_svn1961_66"

 onmouseover="gutterOver(66)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',66);">&nbsp;</span
></td><td id="66"><a href="#66">66</a></td></tr
><tr id="gr_svn1961_67"

 onmouseover="gutterOver(67)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',67);">&nbsp;</span
></td><td id="67"><a href="#67">67</a></td></tr
><tr id="gr_svn1961_68"

 onmouseover="gutterOver(68)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',68);">&nbsp;</span
></td><td id="68"><a href="#68">68</a></td></tr
><tr id="gr_svn1961_69"

 onmouseover="gutterOver(69)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',69);">&nbsp;</span
></td><td id="69"><a href="#69">69</a></td></tr
><tr id="gr_svn1961_70"

 onmouseover="gutterOver(70)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',70);">&nbsp;</span
></td><td id="70"><a href="#70">70</a></td></tr
><tr id="gr_svn1961_71"

 onmouseover="gutterOver(71)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',71);">&nbsp;</span
></td><td id="71"><a href="#71">71</a></td></tr
><tr id="gr_svn1961_72"

 onmouseover="gutterOver(72)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',72);">&nbsp;</span
></td><td id="72"><a href="#72">72</a></td></tr
><tr id="gr_svn1961_73"

 onmouseover="gutterOver(73)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',73);">&nbsp;</span
></td><td id="73"><a href="#73">73</a></td></tr
><tr id="gr_svn1961_74"

 onmouseover="gutterOver(74)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',74);">&nbsp;</span
></td><td id="74"><a href="#74">74</a></td></tr
><tr id="gr_svn1961_75"

 onmouseover="gutterOver(75)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',75);">&nbsp;</span
></td><td id="75"><a href="#75">75</a></td></tr
><tr id="gr_svn1961_76"

 onmouseover="gutterOver(76)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',76);">&nbsp;</span
></td><td id="76"><a href="#76">76</a></td></tr
><tr id="gr_svn1961_77"

 onmouseover="gutterOver(77)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',77);">&nbsp;</span
></td><td id="77"><a href="#77">77</a></td></tr
><tr id="gr_svn1961_78"

 onmouseover="gutterOver(78)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',78);">&nbsp;</span
></td><td id="78"><a href="#78">78</a></td></tr
><tr id="gr_svn1961_79"

 onmouseover="gutterOver(79)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',79);">&nbsp;</span
></td><td id="79"><a href="#79">79</a></td></tr
><tr id="gr_svn1961_80"

 onmouseover="gutterOver(80)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',80);">&nbsp;</span
></td><td id="80"><a href="#80">80</a></td></tr
><tr id="gr_svn1961_81"

 onmouseover="gutterOver(81)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',81);">&nbsp;</span
></td><td id="81"><a href="#81">81</a></td></tr
><tr id="gr_svn1961_82"

 onmouseover="gutterOver(82)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',82);">&nbsp;</span
></td><td id="82"><a href="#82">82</a></td></tr
><tr id="gr_svn1961_83"

 onmouseover="gutterOver(83)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',83);">&nbsp;</span
></td><td id="83"><a href="#83">83</a></td></tr
><tr id="gr_svn1961_84"

 onmouseover="gutterOver(84)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',84);">&nbsp;</span
></td><td id="84"><a href="#84">84</a></td></tr
><tr id="gr_svn1961_85"

 onmouseover="gutterOver(85)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',85);">&nbsp;</span
></td><td id="85"><a href="#85">85</a></td></tr
><tr id="gr_svn1961_86"

 onmouseover="gutterOver(86)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',86);">&nbsp;</span
></td><td id="86"><a href="#86">86</a></td></tr
><tr id="gr_svn1961_87"

 onmouseover="gutterOver(87)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',87);">&nbsp;</span
></td><td id="87"><a href="#87">87</a></td></tr
><tr id="gr_svn1961_88"

 onmouseover="gutterOver(88)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',88);">&nbsp;</span
></td><td id="88"><a href="#88">88</a></td></tr
><tr id="gr_svn1961_89"

 onmouseover="gutterOver(89)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',89);">&nbsp;</span
></td><td id="89"><a href="#89">89</a></td></tr
><tr id="gr_svn1961_90"

 onmouseover="gutterOver(90)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',90);">&nbsp;</span
></td><td id="90"><a href="#90">90</a></td></tr
><tr id="gr_svn1961_91"

 onmouseover="gutterOver(91)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',91);">&nbsp;</span
></td><td id="91"><a href="#91">91</a></td></tr
><tr id="gr_svn1961_92"

 onmouseover="gutterOver(92)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',92);">&nbsp;</span
></td><td id="92"><a href="#92">92</a></td></tr
><tr id="gr_svn1961_93"

 onmouseover="gutterOver(93)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',93);">&nbsp;</span
></td><td id="93"><a href="#93">93</a></td></tr
><tr id="gr_svn1961_94"

 onmouseover="gutterOver(94)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',94);">&nbsp;</span
></td><td id="94"><a href="#94">94</a></td></tr
><tr id="gr_svn1961_95"

 onmouseover="gutterOver(95)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',95);">&nbsp;</span
></td><td id="95"><a href="#95">95</a></td></tr
><tr id="gr_svn1961_96"

 onmouseover="gutterOver(96)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',96);">&nbsp;</span
></td><td id="96"><a href="#96">96</a></td></tr
><tr id="gr_svn1961_97"

 onmouseover="gutterOver(97)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',97);">&nbsp;</span
></td><td id="97"><a href="#97">97</a></td></tr
><tr id="gr_svn1961_98"

 onmouseover="gutterOver(98)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',98);">&nbsp;</span
></td><td id="98"><a href="#98">98</a></td></tr
><tr id="gr_svn1961_99"

 onmouseover="gutterOver(99)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',99);">&nbsp;</span
></td><td id="99"><a href="#99">99</a></td></tr
><tr id="gr_svn1961_100"

 onmouseover="gutterOver(100)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',100);">&nbsp;</span
></td><td id="100"><a href="#100">100</a></td></tr
><tr id="gr_svn1961_101"

 onmouseover="gutterOver(101)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',101);">&nbsp;</span
></td><td id="101"><a href="#101">101</a></td></tr
><tr id="gr_svn1961_102"

 onmouseover="gutterOver(102)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',102);">&nbsp;</span
></td><td id="102"><a href="#102">102</a></td></tr
><tr id="gr_svn1961_103"

 onmouseover="gutterOver(103)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',103);">&nbsp;</span
></td><td id="103"><a href="#103">103</a></td></tr
><tr id="gr_svn1961_104"

 onmouseover="gutterOver(104)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',104);">&nbsp;</span
></td><td id="104"><a href="#104">104</a></td></tr
><tr id="gr_svn1961_105"

 onmouseover="gutterOver(105)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',105);">&nbsp;</span
></td><td id="105"><a href="#105">105</a></td></tr
><tr id="gr_svn1961_106"

 onmouseover="gutterOver(106)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',106);">&nbsp;</span
></td><td id="106"><a href="#106">106</a></td></tr
><tr id="gr_svn1961_107"

 onmouseover="gutterOver(107)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',107);">&nbsp;</span
></td><td id="107"><a href="#107">107</a></td></tr
><tr id="gr_svn1961_108"

 onmouseover="gutterOver(108)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',108);">&nbsp;</span
></td><td id="108"><a href="#108">108</a></td></tr
><tr id="gr_svn1961_109"

 onmouseover="gutterOver(109)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',109);">&nbsp;</span
></td><td id="109"><a href="#109">109</a></td></tr
><tr id="gr_svn1961_110"

 onmouseover="gutterOver(110)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',110);">&nbsp;</span
></td><td id="110"><a href="#110">110</a></td></tr
><tr id="gr_svn1961_111"

 onmouseover="gutterOver(111)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',111);">&nbsp;</span
></td><td id="111"><a href="#111">111</a></td></tr
><tr id="gr_svn1961_112"

 onmouseover="gutterOver(112)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',112);">&nbsp;</span
></td><td id="112"><a href="#112">112</a></td></tr
><tr id="gr_svn1961_113"

 onmouseover="gutterOver(113)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',113);">&nbsp;</span
></td><td id="113"><a href="#113">113</a></td></tr
><tr id="gr_svn1961_114"

 onmouseover="gutterOver(114)"

><td><span title="Add comment" onclick="codereviews.startEdit('svn1961',114);">&nbsp;</span
></td><td id="114"><a href="#114">114</a></td></tr
></table></pre>
<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>
</td>
<td id="lines">
<pre><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>
<pre class="prettyprint lang-java"><table id="src_table_0"><tr
id=sl_svn1961_1

 onmouseover="gutterOver(1)"

><td class="source">/**<br></td></tr
><tr
id=sl_svn1961_2

 onmouseover="gutterOver(2)"

><td class="source"> * OWASP Enterprise Security API (ESAPI)<br></td></tr
><tr
id=sl_svn1961_3

 onmouseover="gutterOver(3)"

><td class="source"> * <br></td></tr
><tr
id=sl_svn1961_4

 onmouseover="gutterOver(4)"

><td class="source"> * This file is part of the Open Web Application Security Project (OWASP)<br></td></tr
><tr
id=sl_svn1961_5

 onmouseover="gutterOver(5)"

><td class="source"> * Enterprise Security API (ESAPI) project. For details, please see<br></td></tr
><tr
id=sl_svn1961_6

 onmouseover="gutterOver(6)"

><td class="source"> * &lt;a href=&quot;http://www.owasp.org/index.php/ESAPI&quot;&gt;http://www.owasp.org/index.php/ESAPI&lt;/a&gt;.<br></td></tr
><tr
id=sl_svn1961_7

 onmouseover="gutterOver(7)"

><td class="source"> *<br></td></tr
><tr
id=sl_svn1961_8

 onmouseover="gutterOver(8)"

><td class="source"> * Copyright (c) 2007 - The OWASP Foundation<br></td></tr
><tr
id=sl_svn1961_9

 onmouseover="gutterOver(9)"

><td class="source"> * <br></td></tr
><tr
id=sl_svn1961_10

 onmouseover="gutterOver(10)"

><td class="source"> * The ESAPI is published by OWASP under the BSD license. You should read and accept the<br></td></tr
><tr
id=sl_svn1961_11

 onmouseover="gutterOver(11)"

><td class="source"> * LICENSE before you use, modify, and/or redistribute this software.<br></td></tr
><tr
id=sl_svn1961_12

 onmouseover="gutterOver(12)"

><td class="source"> * <br></td></tr
><tr
id=sl_svn1961_13

 onmouseover="gutterOver(13)"

><td class="source"> * @author Jeff Williams &lt;a href=&quot;http://www.aspectsecurity.com&quot;&gt;Aspect Security&lt;/a&gt;<br></td></tr
><tr
id=sl_svn1961_14

 onmouseover="gutterOver(14)"

><td class="source"> * @created 2007<br></td></tr
><tr
id=sl_svn1961_15

 onmouseover="gutterOver(15)"

><td class="source"> */<br></td></tr
><tr
id=sl_svn1961_16

 onmouseover="gutterOver(16)"

><td class="source">package org.owasp.esapi.filters;<br></td></tr
><tr
id=sl_svn1961_17

 onmouseover="gutterOver(17)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_18

 onmouseover="gutterOver(18)"

><td class="source">import org.owasp.esapi.ESAPI;<br></td></tr
><tr
id=sl_svn1961_19

 onmouseover="gutterOver(19)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_20

 onmouseover="gutterOver(20)"

><td class="source">import javax.servlet.*;<br></td></tr
><tr
id=sl_svn1961_21

 onmouseover="gutterOver(21)"

><td class="source">import javax.servlet.http.HttpServletRequest;<br></td></tr
><tr
id=sl_svn1961_22

 onmouseover="gutterOver(22)"

><td class="source">import javax.servlet.http.HttpSession;<br></td></tr
><tr
id=sl_svn1961_23

 onmouseover="gutterOver(23)"

><td class="source">import java.io.IOException;<br></td></tr
><tr
id=sl_svn1961_24

 onmouseover="gutterOver(24)"

><td class="source">import java.util.Date;<br></td></tr
><tr
id=sl_svn1961_25

 onmouseover="gutterOver(25)"

><td class="source">import java.util.Stack;<br></td></tr
><tr
id=sl_svn1961_26

 onmouseover="gutterOver(26)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_27

 onmouseover="gutterOver(27)"

><td class="source">/**<br></td></tr
><tr
id=sl_svn1961_28

 onmouseover="gutterOver(28)"

><td class="source"> * A simple servlet filter that limits the request rate to a certain threshold of requests per second.<br></td></tr
><tr
id=sl_svn1961_29

 onmouseover="gutterOver(29)"

><td class="source"> * The default rate is 5 hits in 10 seconds. This can be overridden in the web.xml file by adding<br></td></tr
><tr
id=sl_svn1961_30

 onmouseover="gutterOver(30)"

><td class="source"> * parameters named &quot;hits&quot; and &quot;period&quot; with the desired values. When the rate is exceeded, a short<br></td></tr
><tr
id=sl_svn1961_31

 onmouseover="gutterOver(31)"

><td class="source"> * string is written to the response output stream and the chain method is not invoked. Otherwise,<br></td></tr
><tr
id=sl_svn1961_32

 onmouseover="gutterOver(32)"

><td class="source"> * processing proceeds as normal.<br></td></tr
><tr
id=sl_svn1961_33

 onmouseover="gutterOver(33)"

><td class="source"> */<br></td></tr
><tr
id=sl_svn1961_34

 onmouseover="gutterOver(34)"

><td class="source">public class RequestRateThrottleFilter implements Filter<br></td></tr
><tr
id=sl_svn1961_35

 onmouseover="gutterOver(35)"

><td class="source">{<br></td></tr
><tr
id=sl_svn1961_36

 onmouseover="gutterOver(36)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_37

 onmouseover="gutterOver(37)"

><td class="source">    private int hits = 5;<br></td></tr
><tr
id=sl_svn1961_38

 onmouseover="gutterOver(38)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_39

 onmouseover="gutterOver(39)"

><td class="source">    private int period = 10;<br></td></tr
><tr
id=sl_svn1961_40

 onmouseover="gutterOver(40)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_41

 onmouseover="gutterOver(41)"

><td class="source">    private static final String HITS = &quot;hits&quot;;<br></td></tr
><tr
id=sl_svn1961_42

 onmouseover="gutterOver(42)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_43

 onmouseover="gutterOver(43)"

><td class="source">    private static final String PERIOD = &quot;period&quot;;<br></td></tr
><tr
id=sl_svn1961_44

 onmouseover="gutterOver(44)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_45

 onmouseover="gutterOver(45)"

><td class="source">    /**<br></td></tr
><tr
id=sl_svn1961_46

 onmouseover="gutterOver(46)"

><td class="source">     * Called by the web container to indicate to a filter that it is being<br></td></tr
><tr
id=sl_svn1961_47

 onmouseover="gutterOver(47)"

><td class="source">     * placed into service. The servlet container calls the init method exactly<br></td></tr
><tr
id=sl_svn1961_48

 onmouseover="gutterOver(48)"

><td class="source">     * once after instantiating the filter. The init method must complete<br></td></tr
><tr
id=sl_svn1961_49

 onmouseover="gutterOver(49)"

><td class="source">     * successfully before the filter is asked to do any filtering work.<br></td></tr
><tr
id=sl_svn1961_50

 onmouseover="gutterOver(50)"

><td class="source">     * <br></td></tr
><tr
id=sl_svn1961_51

 onmouseover="gutterOver(51)"

><td class="source">     * @param filterConfig<br></td></tr
><tr
id=sl_svn1961_52

 onmouseover="gutterOver(52)"

><td class="source">     *            configuration object<br></td></tr
><tr
id=sl_svn1961_53

 onmouseover="gutterOver(53)"

><td class="source">     */<br></td></tr
><tr
id=sl_svn1961_54

 onmouseover="gutterOver(54)"

><td class="source">    public void init(FilterConfig filterConfig)<br></td></tr
><tr
id=sl_svn1961_55

 onmouseover="gutterOver(55)"

><td class="source">    {<br></td></tr
><tr
id=sl_svn1961_56

 onmouseover="gutterOver(56)"

><td class="source">        hits = Integer.parseInt(filterConfig.getInitParameter(HITS));<br></td></tr
><tr
id=sl_svn1961_57

 onmouseover="gutterOver(57)"

><td class="source">        period = Integer.parseInt(filterConfig.getInitParameter(PERIOD));<br></td></tr
><tr
id=sl_svn1961_58

 onmouseover="gutterOver(58)"

><td class="source">    }<br></td></tr
><tr
id=sl_svn1961_59

 onmouseover="gutterOver(59)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_60

 onmouseover="gutterOver(60)"

><td class="source">    /**<br></td></tr
><tr
id=sl_svn1961_61

 onmouseover="gutterOver(61)"

><td class="source">     * Checks to see if the current session has exceeded the allowed number<br></td></tr
><tr
id=sl_svn1961_62

 onmouseover="gutterOver(62)"

><td class="source">     * of requests in the specified time period. If the threshold has been<br></td></tr
><tr
id=sl_svn1961_63

 onmouseover="gutterOver(63)"

><td class="source">     * exceeded, then a short error message is written to the output stream and<br></td></tr
><tr
id=sl_svn1961_64

 onmouseover="gutterOver(64)"

><td class="source">     * no further processing is done on the request. Otherwise the request is<br></td></tr
><tr
id=sl_svn1961_65

 onmouseover="gutterOver(65)"

><td class="source">     * processed as normal.<br></td></tr
><tr
id=sl_svn1961_66

 onmouseover="gutterOver(66)"

><td class="source">     * @param request <br></td></tr
><tr
id=sl_svn1961_67

 onmouseover="gutterOver(67)"

><td class="source">     * @param response <br></td></tr
><tr
id=sl_svn1961_68

 onmouseover="gutterOver(68)"

><td class="source">     * @param chain <br></td></tr
><tr
id=sl_svn1961_69

 onmouseover="gutterOver(69)"

><td class="source">     * @throws IOException<br></td></tr
><tr
id=sl_svn1961_70

 onmouseover="gutterOver(70)"

><td class="source">     * @throws ServletException<br></td></tr
><tr
id=sl_svn1961_71

 onmouseover="gutterOver(71)"

><td class="source">     */<br></td></tr
><tr
id=sl_svn1961_72

 onmouseover="gutterOver(72)"

><td class="source">    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException<br></td></tr
><tr
id=sl_svn1961_73

 onmouseover="gutterOver(73)"

><td class="source">    {<br></td></tr
><tr
id=sl_svn1961_74

 onmouseover="gutterOver(74)"

><td class="source">        HttpServletRequest httpRequest = (HttpServletRequest) request;<br></td></tr
><tr
id=sl_svn1961_75

 onmouseover="gutterOver(75)"

><td class="source">        HttpSession session = httpRequest.getSession(true);<br></td></tr
><tr
id=sl_svn1961_76

 onmouseover="gutterOver(76)"

><td class="source">        <br></td></tr
><tr
id=sl_svn1961_77

 onmouseover="gutterOver(77)"

><td class="source">        synchronized( session.getId().intern() ) {<br></td></tr
><tr
id=sl_svn1961_78

 onmouseover="gutterOver(78)"

><td class="source">	        Stack&lt;Date&gt; times = ESAPI.httpUtilities().getSessionAttribute(&quot;times&quot;);<br></td></tr
><tr
id=sl_svn1961_79

 onmouseover="gutterOver(79)"

><td class="source">	        if (times == null)<br></td></tr
><tr
id=sl_svn1961_80

 onmouseover="gutterOver(80)"

><td class="source">	        {<br></td></tr
><tr
id=sl_svn1961_81

 onmouseover="gutterOver(81)"

><td class="source">	            times = new Stack&lt;Date&gt;();<br></td></tr
><tr
id=sl_svn1961_82

 onmouseover="gutterOver(82)"

><td class="source">	            times.push(new Date(0));<br></td></tr
><tr
id=sl_svn1961_83

 onmouseover="gutterOver(83)"

><td class="source">	            session.setAttribute(&quot;times&quot;, times);<br></td></tr
><tr
id=sl_svn1961_84

 onmouseover="gutterOver(84)"

><td class="source">	        }<br></td></tr
><tr
id=sl_svn1961_85

 onmouseover="gutterOver(85)"

><td class="source">	        times.push(new Date());<br></td></tr
><tr
id=sl_svn1961_86

 onmouseover="gutterOver(86)"

><td class="source">	        if (times.size() &gt;= hits)<br></td></tr
><tr
id=sl_svn1961_87

 onmouseover="gutterOver(87)"

><td class="source">	        {<br></td></tr
><tr
id=sl_svn1961_88

 onmouseover="gutterOver(88)"

><td class="source">	            times.removeElementAt(0);<br></td></tr
><tr
id=sl_svn1961_89

 onmouseover="gutterOver(89)"

><td class="source">	        }<br></td></tr
><tr
id=sl_svn1961_90

 onmouseover="gutterOver(90)"

><td class="source">	        Date newest = times.get(times.size() - 1);<br></td></tr
><tr
id=sl_svn1961_91

 onmouseover="gutterOver(91)"

><td class="source">	        Date oldest = times.get(0);<br></td></tr
><tr
id=sl_svn1961_92

 onmouseover="gutterOver(92)"

><td class="source">	        long elapsed = newest.getTime() - oldest.getTime();        <br></td></tr
><tr
id=sl_svn1961_93

 onmouseover="gutterOver(93)"

><td class="source">	        if (elapsed &lt; period * 1000) // seconds<br></td></tr
><tr
id=sl_svn1961_94

 onmouseover="gutterOver(94)"

><td class="source">	        {<br></td></tr
><tr
id=sl_svn1961_95

 onmouseover="gutterOver(95)"

><td class="source">	            response.getWriter().println(&quot;Request rate too high&quot;);<br></td></tr
><tr
id=sl_svn1961_96

 onmouseover="gutterOver(96)"

><td class="source">	            return;<br></td></tr
><tr
id=sl_svn1961_97

 onmouseover="gutterOver(97)"

><td class="source">	        }<br></td></tr
><tr
id=sl_svn1961_98

 onmouseover="gutterOver(98)"

><td class="source">        }        <br></td></tr
><tr
id=sl_svn1961_99

 onmouseover="gutterOver(99)"

><td class="source">        chain.doFilter(request, response);<br></td></tr
><tr
id=sl_svn1961_100

 onmouseover="gutterOver(100)"

><td class="source">    }<br></td></tr
><tr
id=sl_svn1961_101

 onmouseover="gutterOver(101)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_102

 onmouseover="gutterOver(102)"

><td class="source">    /**<br></td></tr
><tr
id=sl_svn1961_103

 onmouseover="gutterOver(103)"

><td class="source">     * Called by the web container to indicate to a filter that it is being<br></td></tr
><tr
id=sl_svn1961_104

 onmouseover="gutterOver(104)"

><td class="source">     * taken out of service. This method is only called once all threads within<br></td></tr
><tr
id=sl_svn1961_105

 onmouseover="gutterOver(105)"

><td class="source">     * the filter&#39;s doFilter method have exited or after a timeout period has<br></td></tr
><tr
id=sl_svn1961_106

 onmouseover="gutterOver(106)"

><td class="source">     * passed. After the web container calls this method, it will not call the<br></td></tr
><tr
id=sl_svn1961_107

 onmouseover="gutterOver(107)"

><td class="source">     * doFilter method again on this instance of the filter.<br></td></tr
><tr
id=sl_svn1961_108

 onmouseover="gutterOver(108)"

><td class="source">     */<br></td></tr
><tr
id=sl_svn1961_109

 onmouseover="gutterOver(109)"

><td class="source">    public void destroy()<br></td></tr
><tr
id=sl_svn1961_110

 onmouseover="gutterOver(110)"

><td class="source">    {<br></td></tr
><tr
id=sl_svn1961_111

 onmouseover="gutterOver(111)"

><td class="source">        // finalize<br></td></tr
><tr
id=sl_svn1961_112

 onmouseover="gutterOver(112)"

><td class="source">    }<br></td></tr
><tr
id=sl_svn1961_113

 onmouseover="gutterOver(113)"

><td class="source"><br></td></tr
><tr
id=sl_svn1961_114

 onmouseover="gutterOver(114)"

><td class="source">}<br></td></tr
></table></pre>
<pre><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>
</td>
</tr></table>

 
<script type="text/javascript">
 var lineNumUnderMouse = -1;
 
 function gutterOver(num) {
 gutterOut();
 var newTR = document.getElementById('gr_svn1961_' + num);
 if (newTR) {
 newTR.className = 'undermouse';
 }
 lineNumUnderMouse = num;
 }
 function gutterOut() {
 if (lineNumUnderMouse != -1) {
 var oldTR = document.getElementById(
 'gr_svn1961_' + lineNumUnderMouse);
 if (oldTR) {
 oldTR.className = '';
 }
 lineNumUnderMouse = -1;
 }
 }
 var numsGenState = {table_base_id: 'nums_table_'};
 var srcGenState = {table_base_id: 'src_table_'};
 var alignerRunning = false;
 var startOver = false;
 function setLineNumberHeights() {
 if (alignerRunning) {
 startOver = true;
 return;
 }
 numsGenState.chunk_id = 0;
 numsGenState.table = document.getElementById('nums_table_0');
 numsGenState.row_num = 0;
 if (!numsGenState.table) {
 return; // Silently exit if no file is present.
 }
 srcGenState.chunk_id = 0;
 srcGenState.table = document.getElementById('src_table_0');
 srcGenState.row_num = 0;
 alignerRunning = true;
 continueToSetLineNumberHeights();
 }
 function rowGenerator(genState) {
 if (genState.row_num < genState.table.rows.length) {
 var currentRow = genState.table.rows[genState.row_num];
 genState.row_num++;
 return currentRow;
 }
 var newTable = document.getElementById(
 genState.table_base_id + (genState.chunk_id + 1));
 if (newTable) {
 genState.chunk_id++;
 genState.row_num = 0;
 genState.table = newTable;
 return genState.table.rows[0];
 }
 return null;
 }
 var MAX_ROWS_PER_PASS = 1000;
 function continueToSetLineNumberHeights() {
 var rowsInThisPass = 0;
 var numRow = 1;
 var srcRow = 1;
 while (numRow && srcRow && rowsInThisPass < MAX_ROWS_PER_PASS) {
 numRow = rowGenerator(numsGenState);
 srcRow = rowGenerator(srcGenState);
 rowsInThisPass++;
 if (numRow && srcRow) {
 if (numRow.offsetHeight != srcRow.offsetHeight) {
 numRow.firstChild.style.height = srcRow.offsetHeight + 'px';
 }
 }
 }
 if (rowsInThisPass >= MAX_ROWS_PER_PASS) {
 setTimeout(continueToSetLineNumberHeights, 10);
 } else {
 alignerRunning = false;
 if (startOver) {
 startOver = false;
 setTimeout(setLineNumberHeights, 500);
 }
 }
 }
 function initLineNumberHeights() {
 // Do 2 complete passes, because there can be races
 // between this code and prettify.
 startOver = true;
 setTimeout(setLineNumberHeights, 250);
 window.onresize = setLineNumberHeights;
 }
 initLineNumberHeights();
</script>

 
 
 <div id="log">
 <div style="text-align:right">
 <a class="ifCollapse" href="#" onclick="_toggleMeta(this); return false">Show details</a>
 <a class="ifExpand" href="#" onclick="_toggleMeta(this); return false">Hide details</a>
 </div>
 <div class="ifExpand">
 
 
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="changelog">
 <p>Change log</p>
 <div>
 <a href="/p/owasp-esapi-java/source/detail?spec=svn1961&amp;r=721">r721</a>
 by manico.james
 on Oct 24, 2009
 &nbsp; <a href="/p/owasp-esapi-java/source/diff?spec=svn1961&r=721&amp;format=side&amp;path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old_path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old=574">Diff</a>
 </div>
 <pre>move to beef code</pre>
 </div>
 
 
 
 
 
 
 <script type="text/javascript">
 var detail_url = '/p/owasp-esapi-java/source/detail?r=721&spec=svn1961';
 var publish_url = '/p/owasp-esapi-java/source/detail?r=721&spec=svn1961#publish';
 // describe the paths of this revision in javascript.
 var changed_paths = [];
 var changed_urls = [];
 
 changed_paths.push('/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java');
 changed_urls.push('/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java?r\x3d721\x26spec\x3dsvn1961');
 
 var selected_path = '/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java';
 
 
 function getCurrentPageIndex() {
 for (var i = 0; i < changed_paths.length; i++) {
 if (selected_path == changed_paths[i]) {
 return i;
 }
 }
 }
 function getNextPage() {
 var i = getCurrentPageIndex();
 if (i < changed_paths.length - 1) {
 return changed_urls[i + 1];
 }
 return null;
 }
 function getPreviousPage() {
 var i = getCurrentPageIndex();
 if (i > 0) {
 return changed_urls[i - 1];
 }
 return null;
 }
 function gotoNextPage() {
 var page = getNextPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoPreviousPage() {
 var page = getPreviousPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoDetailPage() {
 window.location = detail_url;
 }
 function gotoPublishPage() {
 window.location = publish_url;
 }
</script>

 
 <style type="text/css">
 #review_nav {
 border-top: 3px solid white;
 padding-top: 6px;
 margin-top: 1em;
 }
 #review_nav td {
 vertical-align: middle;
 }
 #review_nav select {
 margin: .5em 0;
 }
 </style>
 <div id="review_nav">
 <table><tr><td>Go to:&nbsp;</td><td>
 <select name="files_in_rev" onchange="window.location=this.value">
 
 <option value="/p/owasp-esapi-java/source/browse/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java?r=721&amp;spec=svn1961"
 selected="selected"
 >...s/RequestRateThrottleFilter.java</option>
 
 </select>
 </td></tr></table>
 
 
 <div id="review_instr" class="closed">
 <a class="ifOpened" href="/p/owasp-esapi-java/source/detail?r=721&spec=svn1961#publish">Publish your comments</a>
 <div class="ifClosed">Double click a line to add a comment</div>
 </div>
 
 </div>
 
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="older_bubble">
 <p>Older revisions</p>
 
 
 <div class="closed" style="margin-bottom:3px;" >
 <a class="ifClosed" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/plus.gif" ></a>
 <a class="ifOpened" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/minus.gif" ></a>
 <a href="/p/owasp-esapi-java/source/detail?spec=svn1961&r=574">r574</a>
 by manico.james
 on Jul 22, 2009
 &nbsp; <a href="/p/owasp-esapi-java/source/diff?spec=svn1961&r=574&amp;format=side&amp;path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old_path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old=416">Diff</a>
 <br>
 <pre class="ifOpened">syncronizing on
session.getId().intern()</pre>
 </div>
 
 <div class="closed" style="margin-bottom:3px;" >
 <a class="ifClosed" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/plus.gif" ></a>
 <a class="ifOpened" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/minus.gif" ></a>
 <a href="/p/owasp-esapi-java/source/detail?spec=svn1961&r=416">r416</a>
 by planetlevel
 on Dec 27, 2008
 &nbsp; <a href="/p/owasp-esapi-java/source/diff?spec=svn1961&r=416&amp;format=side&amp;path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old_path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old=410">Diff</a>
 <br>
 <pre class="ifOpened">update Javadoc</pre>
 </div>
 
 <div class="closed" style="margin-bottom:3px;" >
 <a class="ifClosed" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/plus.gif" ></a>
 <a class="ifOpened" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/minus.gif" ></a>
 <a href="/p/owasp-esapi-java/source/detail?spec=svn1961&r=410">r410</a>
 by planetlevel
 on Dec 21, 2008
 &nbsp; <a href="/p/owasp-esapi-java/source/diff?spec=svn1961&r=410&amp;format=side&amp;path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old_path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&amp;old=387">Diff</a>
 <br>
 <pre class="ifOpened">Minor Javadoc fixes to add params,
exceptions, returns</pre>
 </div>
 
 
 <a href="/p/owasp-esapi-java/source/list?path=/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java&start=721">All revisions of this file</a>
 </div>
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="fileinfo_bubble">
 <p>File info</p>
 
 <div>Size: 4257 bytes,
 114 lines</div>
 
 <div><a href="//owasp-esapi-java.googlecode.com/svn/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java">View raw file</a></div>
 </div>
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 </div>
 </div>


</div>

</div>
</div>

<script src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/prettify/prettify.js"></script>
<script type="text/javascript">prettyPrint();</script>


<script src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/source_file_scripts.js"></script>

 <script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/kibbles.js"></script>
 <script type="text/javascript">
 var lastStop = null;
 var initialized = false;
 
 function updateCursor(next, prev) {
 if (prev && prev.element) {
 prev.element.className = 'cursor_stop cursor_hidden';
 }
 if (next && next.element) {
 next.element.className = 'cursor_stop cursor';
 lastStop = next.index;
 }
 }
 
 function pubRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initialized) {
 reloadCursors();
 }
 }
 
 function draftRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initialized) {
 reloadCursors();
 }
 }
 
 function draftDestroyed(data) {
 updateCursorForCell(data.cellId, 'nocursor');
 if (initialized) {
 reloadCursors();
 }
 }
 function reloadCursors() {
 kibbles.skipper.reset();
 loadCursors();
 if (lastStop != null) {
 kibbles.skipper.setCurrentStop(lastStop);
 }
 }
 // possibly the simplest way to insert any newly added comments
 // is to update the class of the corresponding cursor row,
 // then refresh the entire list of rows.
 function updateCursorForCell(cellId, className) {
 var cell = document.getElementById(cellId);
 // we have to go two rows back to find the cursor location
 var row = getPreviousElement(cell.parentNode);
 row.className = className;
 }
 // returns the previous element, ignores text nodes.
 function getPreviousElement(e) {
 var element = e.previousSibling;
 if (element.nodeType == 3) {
 element = element.previousSibling;
 }
 if (element && element.tagName) {
 return element;
 }
 }
 function loadCursors() {
 // register our elements with skipper
 var elements = CR_getElements('*', 'cursor_stop');
 var len = elements.length;
 for (var i = 0; i < len; i++) {
 var element = elements[i]; 
 element.className = 'cursor_stop cursor_hidden';
 kibbles.skipper.append(element);
 }
 }
 function toggleComments() {
 CR_toggleCommentDisplay();
 reloadCursors();
 }
 function keysOnLoadHandler() {
 // setup skipper
 kibbles.skipper.addStopListener(
 kibbles.skipper.LISTENER_TYPE.PRE, updateCursor);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_top', 50);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_bottom', 100);
 // Register our keys
 kibbles.skipper.addFwdKey("n");
 kibbles.skipper.addRevKey("p");
 kibbles.keys.addKeyPressListener(
 'u', function() { window.location = detail_url; });
 kibbles.keys.addKeyPressListener(
 'r', function() { window.location = detail_url + '#publish'; });
 
 kibbles.keys.addKeyPressListener('j', gotoNextPage);
 kibbles.keys.addKeyPressListener('k', gotoPreviousPage);
 
 
 kibbles.keys.addKeyPressListener('h', toggleComments);
 
 }
 </script>
<script src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/code_review_scripts.js"></script>
<script type="text/javascript">
 function showPublishInstructions() {
 var element = document.getElementById('review_instr');
 if (element) {
 element.className = 'opened';
 }
 }
 var codereviews;
 function revsOnLoadHandler() {
 // register our source container with the commenting code
 var paths = {'svn1961': '/trunk/src/main/java/org/owasp/esapi/filters/RequestRateThrottleFilter.java'}
 codereviews = CR_controller.setup(
 {"domainName": null, "projectName": "owasp-esapi-java", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/10034343235110290935", "token": "ABZ6GAfUTjQ5uk7arEixzVWCHxwTjfbm0Q:1469229187937", "profileUrl": "/u/113015210929330814047/", "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "loggedInUserEmail": "billyzhang2010@gmail.com", "relativeBaseUrl": "", "projectHomeUrl": "/p/owasp-esapi-java"}, '', 'svn1961', paths,
 CR_BrowseIntegrationFactory);
 
 // register our source container with the commenting code
 // in this case we're registering the container and the revison
 // associated with the contianer which may be the primary revision
 // or may be a previous revision against which the primary revision
 // of the file is being compared.
 codereviews.registerSourceContainer(document.getElementById('lines'), 'svn1961');
 
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_DRAFT_PLATE, showPublishInstructions);
 
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_PUB_PLATE, pubRevealed);
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_DRAFT_PLATE, draftRevealed);
 codereviews.registerActivityListener(CR_ActivityType.DISCARD_DRAFT_COMMENT, draftDestroyed);
 
 
 
 
 
 
 
 var initialized = true;
 reloadCursors();
 }
 window.onload = function() {keysOnLoadHandler(); revsOnLoadHandler();};

</script>
<script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/dit_scripts.js"></script>

 
 
 
 <script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/10034343235110290935/js/ph_core.js"></script>
 
 
 
 
</div> 

<div id="footer" dir="ltr">
 <div class="text">
 <a href="/projecthosting/terms.html">Terms</a> -
 <a href="http://www.google.com/privacy.html">Privacy</a> -
 <a href="/p/support/">Project Hosting Help</a>
 </div>
</div>
 <div class="hostedBy" style="margin-top: -20px;">
 <span style="vertical-align: top;">Powered by <a href="http://code.google.com/projecthosting/">Google Project Hosting</a></span>
 </div>

 
 


 
 </body>
</html>

