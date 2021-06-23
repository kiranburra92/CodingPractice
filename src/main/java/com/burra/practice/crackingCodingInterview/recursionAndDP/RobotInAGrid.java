package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.ArrayList;
import java.util.List;

// Find all paths of a robot from upper left corner to lower right corner in grid which contains off cells.
// robot can move either right or left at a time.
public class RobotInAGrid {
    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Unoptimized with time O(2^(r+c))
    List<Point> getPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        List<Point> path = new ArrayList<>();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] grid, int r, int c, List<Point> path) {
        if (r < 0 || c < 0 || !grid[r][c])
            return false;
        boolean atOrigin = (r == 0) && (c == 0);
        if (atOrigin || getPath(grid, r - 1, c, path) || getPath(grid, r, c - 1, path)) {
            Point p = new Point(r, c);
            path.add(p);
            return true;
        }
        return false;
    }

    // optimized by storing failed path to avoid recalculation. Time O(r*c)
    List<Point> getPathUsingFailedPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        List<Point> path = new ArrayList<>();
        List<Point> failedPath = new ArrayList<>();
        if (getPathUsingFailedPath(grid, grid.length - 1, grid[0].length - 1, path, failedPath)) {
            return path;
        }
        return null;
    }

    private boolean getPathUsingFailedPath(boolean[][] grid, int r, int c, List<Point> path, List<Point> failedPath) {
        if (r < 0 || c < 0 || !grid[r][c])
            return false;
        boolean atOrigin = (r == 0) && (c == 0);
        Point p = new Point(r, c);
        if (failedPath.contains(p)) return false;
        if (atOrigin || getPathUsingFailedPath(grid, r - 1, c, path, failedPath) ||
                getPathUsingFailedPath(grid, r, c - 1, path, failedPath)) {
            path.add(p);
            return true;
        }
        failedPath.add(p);
        return false;
    }
}
