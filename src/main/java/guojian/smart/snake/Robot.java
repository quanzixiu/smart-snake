package guojian.smart.snake;

/**
 * Author by guojian, Email guojian_k@qq.com, Date on 2018/6/21 10:22 AM
 * PS: Not easy to write code, please indicate.
 * <p>
 * 定义抽象robot类，所有的子类都必须实现search方法，用来返回蛇的头部下一步的方向
 */
public abstract class Robot {
    int[][] snake, walls, world;
    int[] apples, head, tail;

    public Robot(int[][] snake, int[][] walls, int[] apples, int[][] world, int[] head) {
        this.snake = snake.clone();
        this.walls = walls.clone();
        this.world = world.clone();
        this.apples = apples.clone();
        this.head = head.clone();
        tail = getTail();
    }

    /**
     * 返回蛇的尾巴坐标
     * @return
     */
    protected int[] getTail() {
        for (int row = 0; row < Model.ROWS; row++) {
            for (int col = 0; col < Model.COLS; col++) {
                if (snake[row][col] == Model.TAIL) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }


    /**
     * 返回下一步蛇的头部运动方向
     *
     * @return
     */
    public abstract Model.Direction search();
}
