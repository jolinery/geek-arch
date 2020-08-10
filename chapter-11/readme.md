# 

####题1：导致系统不可用的原因有哪些？保障系统稳定高可用的方案有哪些？请分别列举并简述。
解：系统不可用的原因：硬件故障，通信故障，软件故障，发布故障，系统承载故障，自然灾害
保障系统稳定高可用的方案：故障自动检测和转移，制定适合的发布策略，应用做到弹性扩容，异地容灾多活，服务治理(限流、熔断、隔离等)

####题2：
请用你熟悉的编程语言写一个用户密码验证函数，
Boolean checkPW(String 用户ID，String 密码明文，String 密码密文)

解答：
public Boolean checkPW(String uid,String password,String passwordMD5){
    //把uid当做 盐 生成密文比较
    String md5pw = DigestUtils.md5Hex(uid+password);
    return md5pw.equals(passwordMD5);
}




