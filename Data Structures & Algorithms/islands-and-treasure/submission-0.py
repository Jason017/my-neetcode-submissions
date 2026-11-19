class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        m, n = len(grid), len(grid[0])
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        INF = 2**31 - 1

        def bfs(r, c):
            q = deque([(r, c)])
            visited = [[False] * n for _ in range(m)]
            visited[r][c] = True
            steps = 0

            while q:
                for _ in range(len(q)):
                    r, c = q.popleft()
                    if grid[r][c] == 0:
                        return steps

                    for dr, dc in dirs:
                        nr, nc = r + dr, c + dc
                        if nr in range(m) and nc in range(n) and not visited[nr][nc] and grid[nr][nc] != -1:
                            visited[nr][nc] = True
                            q.append((nr, nc))
                steps += 1
            return INF

        for r in range(m):
            for c in range(n):
                if grid[r][c] == INF:
                    grid[r][c] = bfs(r, c)
