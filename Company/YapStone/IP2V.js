function IP2V(ip)
{
  re=/(\d+)\.(\d+)\.(\d+)\.(\d+)/g; //匹配IP地址的正则表达式
  if(re.test(ip))
  {
    return RegExp.$1*Math.pow(255,3))+RegExp.$2*Math.pow(255,2))+RegExp.$3*255+RegExp.$4*1
  }else{
    throw new Error("Not a valid IP address!")
  }
}