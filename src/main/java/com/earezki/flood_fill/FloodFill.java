package com.earezki.flood_fill;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int ic = image[sr][sc];

        Stack<Integer> indices = new Stack<>();
        indices.push(toIdx(sr, sc, cols));

        Set<Integer> seen = new HashSet<>();

        int[] adjacentIndices = new int[4];

        while (!indices.isEmpty()) {
            int idx = indices.pop();
            seen.add(idx);

            sr = xOfIdx( idx, cols );
            sc = yOfIdx( idx, cols );

            //System.out.println("x="+sr + ",y="+sc + ",idx="+idx);
            image[sr][sc] = color;

            adjacentIndices[0] = toIdx(Math.min(sr + 1, rows - 1), sc, cols);
            adjacentIndices[1] = toIdx(Math.max(sr - 1, 0), sc , cols);
            adjacentIndices[2] = toIdx(sr, Math.min(sc + 1, cols - 1), cols);
            adjacentIndices[3] = toIdx(sr, Math.max(sc - 1, 0), cols);

            for (int ai : adjacentIndices) {
                if (!seen.contains(ai) && hasColor(image, ai, ic)) {
                    seen.add(ai);
                    indices.push(ai);
                }
            }

        }

        return image;
    }

    boolean hasColor(int[][] image, int idx, int color) {
        int x = xOfIdx(idx, image[0].length);
        int y = yOfIdx(idx, image[0].length);

        if (x >= image.length || y >= image[0].length || x < 0 || y <  0) {
            return false;
        }

        //System.out.println("x="+x + ",y="+y + ",c="+color+"imgc="+image[x][y]);
        return (image[x][y] == color);
    }

    int toIdx(int x, int y, int cols) {
        return x * cols + y;
    }

    int xOfIdx(int idx, int cols) {
        return idx / cols;
    }

    int yOfIdx(int idx, int cols) {
        return idx % cols;
    }

}
