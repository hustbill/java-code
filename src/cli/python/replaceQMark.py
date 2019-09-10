def replaceQMark(s):
    low = "abc"
    def getCh(a, b):
        for i in low:
            if i==a or i==b:
                continue
                return i
        res=[]
        for i, char in enumerate(s):
            if char=='?':
                res.append(getCh(res[-1], s[i+1]))
            else:
                res.append(char)
        return "".join(res)

# ret = replaceQMark("????abc?d?");
ret = replaceQMark("abc?d?");
print(ret);
