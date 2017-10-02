package com.tests.stonegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class StoneGame {
    private static int playerScores = 0;
    private static int computerScores = 0;
    private static boolean playing = true;
    private static String[] playerSkills = {"石头", "剪子", "布"};

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("输入:石头[1] 剪子[2] 布[3] 退出[4]");
            while (playing) {
                int playerSkill = Integer.parseInt(bufferedReader.readLine());
                Random random = new Random();
                int computerSkill = random.nextInt(3) + 1;
                if (playerSkill == 4) {
                    System.out.println("Bye.");
                    playing = false;
                    break;
                }
                if (playerSkill > 0 && playerSkill < 4) {
                    System.out.println("玩家: " + playerSkills[playerSkill - 1]);
                    System.out.println("电脑: " + playerSkills[computerSkill - 1]);
                    compare(playerSkill, computerSkill);
                    System.out.println("玩家分数: " + playerScores + " " + "电脑分数: " + computerScores);
                } else {
                    System.out.println("请重试.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("请输入正确的数字!");
        }
    }

    private static void compare(int playerSkill, int computerSkill) {
        if (playerSkill == computerSkill) {
            System.out.println("平局.");
            return;
        }
        if (playerSkill == 1) { // player skill is stone.
            if (computerSkill == 2) {
                System.out.println("玩家胜利.");
                playerScores++;
            } else {
                System.out.println("电脑胜利.");
                computerScores++;
            }
        }
        if (playerSkill == 2) { // player skill is scissor.
            if (computerSkill == 3) {
                System.out.println("玩家胜利.");
                playerScores++;
            } else {
                System.out.println("电脑胜利.");
                computerScores++;
            }
        }

        if (playerSkill == 3) { // player skill is cloth.
            if (computerSkill == 1) {
                System.out.println("玩家胜利.");
                playerScores++;
            } else {
                System.out.println("电脑胜利.");
                computerScores++;
            }
        }
    }
}
