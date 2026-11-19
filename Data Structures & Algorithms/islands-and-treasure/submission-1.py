class Solution:
    def islandsAndTreasure(self, rooms: List[List[int]]) -> None:
        m, n = len(rooms), len(rooms[0])
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        INF = 2**31 - 1

        q = deque()
        for r in range(m):
            for c in range(n):
                if rooms[r][c] == 0:
                    q.append((r, c))

        while q:
            r, c = q.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if nr in range(m) and nc in range(n) and rooms[nr][nc] == INF:
                    rooms[nr][nc] = rooms[r][c] + 1
                    q.append((nr, nc))