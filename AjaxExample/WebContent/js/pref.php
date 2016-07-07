<?php
  header("Content-type: application/xml");
  $url = "http://ws.bzen.net/pgtop/pref.xml";
  readfile($url);
?>