package com.thinkbiganalytics.feedmgr.service;

import com.thinkbiganalytics.feedmgr.InvalidOperationException;
import com.thinkbiganalytics.feedmgr.rest.model.FeedCategory;
import com.thinkbiganalytics.feedmgr.rest.model.FeedMetadata;
import com.thinkbiganalytics.feedmgr.rest.model.FeedSummary;
import com.thinkbiganalytics.feedmgr.rest.model.NifiFeed;
import com.thinkbiganalytics.feedmgr.rest.model.RegisteredTemplate;
import com.thinkbiganalytics.feedmgr.rest.model.UIFeed;
import com.thinkbiganalytics.nifi.rest.model.NifiProperty;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by sr186054 on 2/23/16.
 */
@Service
public interface MetadataService {

    void registerTemplate(RegisteredTemplate registeredTemplate);

    List<NifiProperty> getTemplateProperties(String templateId);

    RegisteredTemplate getRegisteredTemplate(String templateId);

    RegisteredTemplate getRegisteredTemplateByName(String templateName);

    RegisteredTemplate getRegisteredTemplateWithAllProperties(String templateId);

    RegisteredTemplate getRegisteredTemplateForNifiProperties(final String nifiTemplateId, final String nifiTemplateName);

    void deleteRegisteredTemplate(String templateId);

    // List<String> getRegisteredTemplateIds();

    List<RegisteredTemplate> getRegisteredTemplates();

    NifiFeed createFeed(FeedMetadata feedMetadata);

    void saveFeed(FeedMetadata feed);

    FeedSummary enableFeed(String feedId);

    FeedSummary disableFeed(String feedId);

    Collection<FeedMetadata> getFeeds();

    Collection<? extends UIFeed> getFeeds(boolean verbose);

    List<FeedSummary> getFeedSummaryData();

    List<FeedSummary> getFeedSummaryForCategory(String categoryId);

    FeedMetadata getFeedByName(String categoryName, String feedName);

    FeedMetadata getFeedById(String feedId);

    FeedMetadata getFeedById(String feedId, boolean refreshTargetTableSchema);

    List<FeedMetadata> getReusableFeeds();

    Collection<FeedCategory> getCategories();

    FeedCategory getCategoryBySystemName(final String name);

    void saveCategory(FeedCategory category);

    boolean deleteCategory(String categoryId) throws InvalidOperationException;
}
