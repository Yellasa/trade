package com.liantuo.deposit.common.plugin.mybatis.vo;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Page
{
	private int showPageCount = 10;// //分页标签显示10个页码
    private int showCount = 10; // 每页显示记录数
    private int totalPage; // 总页数
    private int totalResult; // 总记录数
    private int currentPage; // 当前页
    private int currentResult; // 当前记录起始索引
    private boolean entityOrField; // true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
    private String pageStr; // 最终页面显示的底部翻页导航，详细见：getPageStr();

  
     
    public int getShowPageCount()
    {
        return showPageCount;
    }

    public void setShowPageCount(int showPageCount)
    {
        this.showPageCount = showPageCount;
    }

    public int getTotalPage()
    {
        if (totalResult % showCount == 0)
            totalPage = totalResult / showCount;
        else
            totalPage = totalResult / showCount + 1;
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getTotalResult()
    {
        return totalResult;
    }

    public void setTotalResult(int totalResult)
    {
        this.totalResult = totalResult;
    }

    public int getCurrentPage()
    {
        if (currentPage <= 0)
            currentPage = 1;
//        if (currentPage > getTotalPage())
//            currentPage = getTotalPage();
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public String getPageStr(String fromId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<table width=\"95%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
        sb.append("<tr><td class=\"txtNextPage\" valign=\"bottom\" align=\"left\">\n");
        sb.append("共 " + totalResult + " 条记录");
        if (totalResult > 0)
        {
            sb.append("，共 " + totalPage + "页,当前显示第" + (this.getCurrentResult() + 1) + " - " + ((this.getCurrentResult() + showCount) > totalResult ? totalResult : (this.getCurrentResult() + showCount)) + "条 </td>\n");

            sb.append("<td class=\"txtNextPage\" align=right valign=\"bottom\">\n");
            if (this.getCurrentPage() == 1)
            {
                sb.append("<span>首页</span>&nbsp;\n");
                sb.append("<span>上一页</span>\n");
            }
            else
            {
                sb.append("<a href=\"javascript:gotoPage(1)\">首页</a>&nbsp;\n");
                sb.append("<a href=\"javascript:gotoPage(" + (this.getCurrentPage() - 1) + ")\">上一页</a>\n");

            }
            int startTag = 1;
            if (this.getCurrentPage() > showPageCount / 2)
            {
                startTag = this.getCurrentPage() - (showPageCount / 2);
            }
            int endTag = startTag + showPageCount - 1;
            for (int i = startTag; i <= totalPage && i <= endTag; i++)
            {
                if (this.getCurrentPage() == i)
                {
                    sb.append("<a href=\"javascript:gotoPage(" + i + ")\"<font color=\"#FF6600\"><b>" + i + "</b></font></a>\n");
                }
                else
                {
                    sb.append("<a href=\"javascript:gotoPage(" + i + ")\">" + i + "</a>\n");
                }
            }
            if (this.getCurrentPage() >= totalPage)
            {
                sb.append("<span>下一页</span>\n");
                sb.append("<span>尾页</span>&nbsp;\n");
            }
            else
            {
                sb.append("<a href=\"javascript:gotoPage(" + (this.getCurrentPage() + 1) + ")\">下一页</a>\n");
                sb.append("<a href=\"javascript:gotoPage(" + totalPage + ")\">尾页</a>&nbsp;\n");
            }
            sb.append("</td></tr></table>");
            sb.append("<script type=\"text/javascript\">\n");
            sb.append("function gotoPage(page){");
            sb.append("	var queryForm=document.getElementById('" + fromId + "');\n");
            sb.append("	if(true && queryForm){\n");
            sb.append("		var url = queryForm.getAttribute(\"action\");\n");
            sb.append("		if(url.indexOf('?')>-1){url += \"&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
            sb.append("		else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
            sb.append("		queryForm.action = url+page;\n");
            sb.append("		queryForm.submit();\n");
            sb.append("	}else{\n");
            sb.append("		var url = document.location+'';\n");
            sb.append("		if(url.indexOf('?')>-1){\n");
            sb.append("			if(url.indexOf('currentPage')>-1){\n");
            sb.append("				var reg = /currentPage=\\d*/g;\n");
            sb.append("				url = url.replace(reg,'currentPage=');\n");
            sb.append("			}else{\n");
            sb.append("				url += \"&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";\n");
            sb.append("			}\n");
            sb.append("		}else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
            sb.append("		document.location = url + page;\n");
            sb.append("	}\n");
            sb.append("}\n");
            sb.append("</script>\n");
        }
        else
        {
            sb.append("</td><td></td></tr></table>");
        }
        return sb.toString();
    }

    public void setPageStr(String pageStr)
    {
        this.pageStr = pageStr;
    }

    public int getShowCount()
    {
        return showCount;
    }

    public void setShowCount(int showCount)
    {
        this.showCount = showCount;
    }

    public int getCurrentResult()
    {
        currentResult = (getCurrentPage() - 1) * getShowCount();
        if (currentResult < 0)
            currentResult = 0;
        return currentResult;
    }

    public void setCurrentResult(int currentResult)
    {
        this.currentResult = currentResult;
    }

    public boolean isEntityOrField()
    {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField)
    {
        this.entityOrField = entityOrField;
    }
    
    @JsonIgnore
    public int getEndIndex(){
      return this.getCurrentResult()+this.showCount;
    }

    
}
