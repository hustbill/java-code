def longestSub(text):
   idx, cnt, res, max = 0 ,{}, "", -1

   for i in range(len(text)):
       c = text[i]
       cnt[c] = cnt.get(c, 0)+1
       while cnt[c]>2:
           d = text[idx]
           idx+=1
           cnt[d]-=1
       if max< i-idx:
           max = i-idx
           res = text[idx:i+1]
   return res

ret = longestSub("abcdefghabcdefghlmnlmnlmn");
print(ret);
