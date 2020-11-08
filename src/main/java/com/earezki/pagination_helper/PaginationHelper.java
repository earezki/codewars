package com.earezki.pagination_helper;

import java.util.List;

public class PaginationHelper<I> {

    private static final int ONE_PAGE_COUNT = 1;
    private static final int NOT_FOUND = -1;

    private final List<I> items;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.items = List.copyOf(collection);
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.items.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int itemsCount = itemCount();
        int numberOfPages = itemsCount / itemsPerPage;
        int lastPage = Math.min(lastPageItemsCount(), ONE_PAGE_COUNT);
        return numberOfPages + lastPage;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (isPageOutOfBounds(pageIndex)) {
            return NOT_FOUND;
        }

        int numberOfPages = pageCount();
        int lastPageIndex = numberOfPages - ONE_PAGE_COUNT;

        return pageIndex < lastPageIndex ?
                itemsPerPage :
                lastPageItemsCount();
    }

    private boolean isPageOutOfBounds(int pageIndex) {
        return pageIndex < 0 || pageIndex >= pageCount();
    }

    private int lastPageItemsCount() {
        return itemCount() % itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (isItemOutOfBounds(itemIndex)) {
            return NOT_FOUND;
        }

        return itemIndex / itemsPerPage;
    }

    private boolean isItemOutOfBounds(int itemIndex) {
        return itemIndex < 0 || itemIndex >= itemCount();
    }

}