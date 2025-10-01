package com.earezki.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

    @Test
    void groupAnagrams() {
        GroupAnagrams sut = new GroupAnagrams();

        assertEquals(
                List.of( List.of("bat"),  List.of("tan", "nat") , List.of("eat","tea","ate")),
                sut.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})
        );
    }
}