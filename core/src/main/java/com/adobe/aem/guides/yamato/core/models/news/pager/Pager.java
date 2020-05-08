package com.adobe.aem.guides.yamato.core.models.news.pager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
    private static final int ARTICLE_DISPLAY_COUNT = 10;

    @RequestAttribute
    private int articlesSize;

    @SlingObject
    private SlingHttpServletRequest request;

    private List<PagerLink> pagerLinks = new ArrayList<>();

    private Preview preview;

    private Next next;

    @PostConstruct
    public void init() {
        int pagerCount = (int) Math.ceil((double) articlesSize / ARTICLE_DISPLAY_COUNT);
        for (int i = 1; i <= pagerCount; i++) {
            pagerLinks.add(new PagerLink(currentPageNumber(), i));
        }
        preview = new Preview(currentPageNumber());
        next = new Next(currentPageNumber(), pagerCount);
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
}
