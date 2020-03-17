package com.adobe.aem.guides.yamato.core.models.news.pager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.adobe.aem.guides.yamato.core.models.news.pager.items.Begin;
import com.adobe.aem.guides.yamato.core.models.news.pager.items.End;
import com.adobe.aem.guides.yamato.core.models.news.pager.items.Next;
import com.adobe.aem.guides.yamato.core.models.news.pager.items.PagerLink;
import com.adobe.aem.guides.yamato.core.models.news.pager.items.Preview;
import com.day.cq.commons.PathInfo;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Pager {
    private final int ARTICLE_DISPLAY_COUNT = 10;

    @RequestAttribute
    private int articlesSize;

    @SlingObject
    private SlingHttpServletRequest request;

    private List<PagerLink> pagerLinks = new ArrayList<PagerLink>();

    private Preview preview;

    private Next next;

    private Begin begin;

    private End end;

    @PostConstruct
    public void init() {
        int pagerCount = (int) Math.ceil((double) articlesSize / ARTICLE_DISPLAY_COUNT);
        for (int i = 1; i <= pagerCount; i++) {
            pagerLinks.add(new PagerLink(pagerCount, currentPageNumber(), i));
        }
        preview = new Preview(currentPageNumber());
        next = new Next(currentPageNumber(), pagerCount);
        begin = new Begin(ARTICLE_DISPLAY_COUNT, currentPageNumber());
        end = new End(begin, ARTICLE_DISPLAY_COUNT);
    }

    private int currentPageNumber() {
        String[] selectors = new PathInfo(request.getPathInfo()).getSelectors();
        if (selectors.length == 0) return 1;
        return Integer.parseInt(String.join("", selectors));
    }

    public List<PagerLink> getPagerLinks() {
        return pagerLinks;
    }

    public Preview getPreview() {
        return preview;
    }

    public Next getNext() {
        return next;
    }

    public int getBegin() {
        return begin.value();
    }

    public int getEnd() {
        return end.value();
    }
}
