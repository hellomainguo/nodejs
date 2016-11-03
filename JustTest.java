var content = "";
// 为语音识别方便。因为这个太长
var contentArray = [];
// 正文的距离（若某段文字离正文距离太远，就不要它了）
var contentDistance = 0;
$('p,strong').each(function (i) {
    // console.log(this.innerHTML);
    // 父亲或者爷爷是a标签
    contentDistance++;
    // 正文已经有50字以上了，而下一个标签又离正文距离太远，就结束。
    if (contentDistance > 6 && content.length > 50)
        return false;
    if (!doWeHaveATag(this))
    {
        var pChild;
        if (this.childNodes)
            pChild = this.childNodes[0];
        if (pChild.nodeName === '#text')
        {
            content += pChild.nodeValue;
            contentArray.push(pChild.nodeValue);
            contentDistance = 0;
        }
    }
});

// 看看自己活着祖先有无a标签
function doWeHaveATag(node)
{
    if (node.nodeName == 'A')
        return true;
    else if (node.parentNode)
        return doWeHaveATag(node.parentNode);
    else
        return false;
}