package com.zhou.common;

public class Status {
	public static final int BOSS = 0;//老大
    public static final int MANAGER = 1;//人事部经理
    public static final int NORMAL_STAFF = 2;//群众
    public static final int PRACTICE_STUDENT = 3;//
    public static final int TASK_NOT_PULL = 4;//任务发布但并为领取
    public static final int TASK_FINISH = 7;//任务成功完成
    public static final int TASK_NOT_FINISH = 5;//任务没有完成但在未来完成
    public static final int TASK_BREAK = 6;//任务不得不中止结束任务
    public static final int PRIORITY_NORMAL = 8;//任务状态为一般
    public static final int PRIORITY_QUICK = 9;//任务状态为紧急
    public static final int IS_NOT_LEAF = 10;//任务非叶子节点
    public static final int IS_LEAF = 11;//任务是叶子节点
    public static final int ACTION_SUCCESS = 12;//操作成功
    public static final int ACTION_FAIL = 13;//操作失败
    public static final int INVALID_OPERATION = 14;//无效操作
    public static final int NOT_EXIXTS =15;//员工不存在
    public static final int PASSWORD_NOT_CORRECT = 16;//密码不正确
    public static final int ALREADYEXISTS = 17;//已经存在该员工
    public static final int LOGIN_SUCCESS = 18;//登录成功
    public static final int NO_RECORDS = 19;//没有任何记录
    public static final int DATA_NULL =20;//数据为空
}