var content = "";
// Ϊ����ʶ�𷽱㡣��Ϊ���̫��
var contentArray = [];
// ���ĵľ��루��ĳ�����������ľ���̫Զ���Ͳ�Ҫ���ˣ�
var contentDistance = 0;
$('p,strong').each(function (i) {
    // console.log(this.innerHTML);
    // ���׻���үү��a��ǩ
    contentDistance++;
    // �����Ѿ���50�������ˣ�����һ����ǩ�������ľ���̫Զ���ͽ�����
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

// �����Լ�������������a��ǩ
function doWeHaveATag(node)
{
    if (node.nodeName == 'A')
        return true;
    else if (node.parentNode)
        return doWeHaveATag(node.parentNode);
    else
        return false;
}