import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class Project_20212579 extends JFrame{
    Project_20212579() {
        // 메인 패널 생성
        setTitle("엑소 백현 팬페이지");
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(new Dimension(1300, 1000));

        // 팬페이지 제목 표시
        JPanel panel_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_title.setPreferredSize(new Dimension(1500, 70));
        JTextField t_pagename = new JTextField("-`♡´- ONE&ONLY 천재아이돌 백현 -`♥´-");
        Font font1 = new Font("맑은 고딕", Font.PLAIN, 50).deriveFont(Font.BOLD);
        t_pagename.setFont(font1);
        t_pagename.setPreferredSize(new Dimension(1500, 70));
        t_pagename.setHorizontalAlignment(JTextField.CENTER);
        t_pagename.setEditable(false);
        t_pagename.setBackground(Color.WHITE);
        panel_title.add(t_pagename);
        mainPanel.add(panel_title);

        // 프로필 패널 생성
        JPanel panel_profile = new JPanel(new BorderLayout());
        panel_profile.setPreferredSize(new Dimension(1200, 450));

        // 프로필 사진 배치
        String imagePath = "../img/bbh.jpg";
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(250, 460, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        JLabel label = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_profile.add(label, BorderLayout.CENTER);

        // 프로필 작성
        JTextArea area_profile = new JTextArea(
                                "본명: 변백현 (邊伯賢[훈음] / Byun Baekhyun)\n"
                                +"생일 :1992년 5월 6일 (31세)\n"
                                +"출생: 경기도 부천시 중동\n"
                                +"국적: 대한민국\n"
                                +"본관: 원주 변씨 (原州 邉氏)\n"
                                +"신체: 174cm｜64kg｜O형\n"
                                +"가족: 부모님, 형, 몽룡(반려견)\n"
                                +"소속사: SM엔터테인먼트\n"
                                +"소속 그룹: EXO｜EXO-CBX｜SuperM｜HEARTSTEEL\n"
                                +"포지션: 메인보컬 (EXO)｜리더, 메인보컬 (SuperM)\n"
                                +"데뷔: 2012년 4월 8일 EXO-K 미니 1집 MAMA\n"
                                +"MBTI: ESTJ\n"
                                +"별명: 큥, 천재 아이돌, 배켜니, 하얀머리, 1군 수장 등\n"
                                +"상징 캐릭터: 터래기 - 백현을 상징하는 이모티콘('.ㅅ')과 반려견 몽룡이의 콜라보 캐릭터\n"
                                +"초능력: 빛(Light)\n"
                                +"고유 번호(등 번호): 04\n"
                                +"좋아하는 색깔: 빨간색\n"
                                +"싫어하는 음식: 오이\n"
                                +"좌우명: 노력만이 살 길이다"); // 프로필 내용은 줄여서 표시
        Font font2 = new Font("맑은 고딕", Font.PLAIN, 20);
        area_profile.setFont(font2);
        area_profile.setEditable(false);
        area_profile.setLineWrap(true);
        JScrollPane scroll_profile = new JScrollPane(area_profile);
        scroll_profile.setPreferredSize(new Dimension(880, 460));
        panel_profile.add(scroll_profile, BorderLayout.EAST);
        mainPanel.add(panel_profile);

        // 카드 레이아웃 패널 생성
        JPanel cardPanel =new JPanel(new CardLayout()) ;
        cardPanel.setPreferredSize(new Dimension(1200, 460));

        // 궁합 테스트 패널 생성
        JPanel panel_test = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_test.setPreferredSize(new Dimension(1200, 460));
        JTextField t_test = new JTextField("백현과의 궁합 테스트");
        Font font3 = new Font("맑은 고딕", Font.PLAIN, 35).deriveFont(Font.BOLD);
        t_test.setFont(font3);
        t_test.setPreferredSize(new Dimension(1200, 50));
        t_test.setHorizontalAlignment(JTextField.CENTER);
        t_test.setEditable(false);
        t_test.setBackground(Color.WHITE);
        panel_test.add(t_test);


        // 궁합 테스트 내부 패널1(이름 궁합) 생성
        JPanel innerPanel1 = new JPanel();
        innerPanel1.setPreferredSize(new Dimension(570, 460));
        panel_test.add(innerPanel1);

        JLabel l1_name = new JLabel("<이름 궁합>");
        Font font4 = new Font("맑은 고딕", Font.PLAIN, 20).deriveFont(Font.BOLD);
        l1_name.setFont(font4);
        l1_name.setHorizontalAlignment(SwingConstants.CENTER);
        l1_name.setPreferredSize(new Dimension(570, 30));

        JLabel l2_name= new JLabel("이름을 한칸에 한글자씩 입력하고, 한칸에는 초성/중성/종성을 띄어 써주세요");
        Font font5 = new Font("맑은 고딕", Font.PLAIN, 15);
        l2_name.setFont(font5);
        l2_name.setHorizontalAlignment(SwingConstants.CENTER);
        l2_name.setPreferredSize(new Dimension(570, 20));

        JLabel l3_name= new JLabel("이름이 2글자면 성을 한번 더 입력하고, 4글자 이상이면 3글자까지만 입력하세요");
        l3_name.setFont(font5);
        l3_name.setHorizontalAlignment(SwingConstants.CENTER);
        l3_name.setPreferredSize(new Dimension(570, 20));

        JLabel l4_name= new JLabel("입력예시: 권희예 -> [ㄱ ㅝ ㄴ] [ㅎ ㅢ] [ㅇ ㅖ]");
        l4_name.setFont(font5);
        l4_name.setHorizontalAlignment(SwingConstants.CENTER);
        l4_name.setPreferredSize(new Dimension(570, 20));

        JTextField t1_name = new JTextField();
        t1_name.setColumns(8);

        JTextField t2_name = new JTextField();
        t2_name.setColumns(8);

        JTextField t3_name = new JTextField();
        t3_name.setColumns(8);

        // 이름 궁합 알고리즘
        char[] han = {
                'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ',
                'ㄷ', 'ㄸ', 'ㄹ', 'ㄺ', 'ㄻ',
                'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ',
                'ㅁ', 'ㅂ', 'ㅃ', 'ㅄ',
                'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',
                'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
                'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ',
                'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ',
                'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ',
                'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'

        };

        // 한글 획수 저장 배열(한글 배열과 인덱스 동일)
        int[] han_num = {
                2, 4, 4, 2, 5, 5,
                3, 6, 5, 7, 9,
                9, 7, 9, 9, 8,
                4, 4, 8, 6,
                2, 4, 1, 3, 6,
                4, 3, 4, 4, 3,
                2, 3, 3, 4, 2,
                3, 3, 4, 2, 4,
                5, 3, 3, 2, 4,
                5, 3, 3, 1, 2, 1};

        // 중간 계산값을 저장할 배열
        int[] step1 = new int[5];
        int[] step2 = new int[4];
        int[] step3 = new int[3];
        int[] step4 = new int[2];

        // 백현이 이름 획수
        int Byun = 9 ;
        int Baek = 9 ;
        int Hyun = 8 ;

        JButton b_name = new JButton("궁합 보기") ;
        b_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total1 = calculateTotal(t1_name.getText(), han, han_num);
                int total2 = calculateTotal(t2_name.getText(), han, han_num);
                int total3 = calculateTotal(t3_name.getText(), han, han_num);

                int[] step0 = {Byun, total1, Baek, total2, Hyun, total3};

                for(int i=0; i<step0.length-1; i++){
                    step1[i] = (step0[i]+step0[i+1]) % 10 ;
                }

                for(int i=0; i<step1.length-1; i++){
                    step2[i] = (step1[i]+step1[i+1]) % 10 ;
                }

                for(int i=0; i<step2.length-1; i++){
                    step3[i] = (step2[i]+step2[i+1]) % 10 ;
                }

                for(int i=0; i<step3.length-1; i++){
                    step4[i] = (step3[i]+step3[i+1]) % 10 ;
                }

                String Percentage = "" + step4[0] + step4[1];


                // 대화상자 폰트 설정
                Font font = new Font("맑은 고딕", Font.BOLD, 18);
                UIManager.put("OptionPane.messageFont", font);

                // 대화상자 표시
                JOptionPane.showMessageDialog(null, "백현이와 이름궁합 결과: " + Percentage + "%", "궁합 결과", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        innerPanel1.add(l1_name);
        innerPanel1.add(l2_name);
        innerPanel1.add(l3_name);
        innerPanel1.add(l4_name);
        innerPanel1.add(t1_name);
        innerPanel1.add(t2_name);
        innerPanel1.add(t3_name);
        innerPanel1.add(b_name);


        // 궁합 테스트 내부 패널2(mbit 궁합) 생성
        JPanel innerPanel2 = new JPanel();
        innerPanel2.setPreferredSize(new Dimension(570, 460));
        panel_test.add(innerPanel2);

        JLabel l1_mbti = new JLabel("<mbti 궁합>");
        l1_mbti.setFont(font4);
        l1_mbti.setHorizontalAlignment(SwingConstants.CENTER);
        l1_mbti.setPreferredSize(new Dimension(570, 30));

        JLabel l2_mbti= new JLabel("mbti를 입력해 주세요");
        l2_mbti.setFont(font5);
        l2_mbti.setHorizontalAlignment(SwingConstants.CENTER);
        l2_mbti.setPreferredSize(new Dimension(570, 30));

        JTextField t1_mbti = new JTextField("");
        t1_mbti.setColumns(8);
        t1_mbti.setHorizontalAlignment(JTextField.CENTER);
        t1_mbti.setFont(font5);

        JTextField t2_mbti = new JTextField("결과출력창");
        t2_mbti.setHorizontalAlignment(JTextField.CENTER);
        t2_mbti.setPreferredSize(new Dimension(570, 30));
        t2_mbti.setFont(font5.deriveFont(Font.BOLD));

        // mbti 궁합 알고리즘
        JButton b_mbti = new JButton("궁합보기") ;
        b_mbti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2_mbti.setText("");

                String user_mbti = t1_mbti.getText().toUpperCase() ;
                String[] love = new String[] {"ISFP", "ISTP"};
                for (String element : love) {
                    if(user_mbti.equals(element)) {
                        t2_mbti.setText("(경) 당신은 ESTJ인 백현이와 천생연분 입니다! (축)");
                    }
                }

                String[] good = new String[] {"ISFJ","ESFJ","ISTJ","ESTJ"};
                for (String element : good) {
                    if(user_mbti.equals(element)) {
                        t2_mbti.setText("오! 당신은 ESTJ인 백현이와 좋은 인연 입니다!");
                    }
                }

                String[] soso = new String[] {"INTJ", "ENTJ","INTP", "ENTP", "ESFP","ESTP"};
                for (String element : soso) {
                    if(user_mbti.equals(element)) {
                        t2_mbti.setText("당신은 ESTJ인 백현이와 무난한 궁합이군요~");
                    }
                }

                String[] bad = new String[] {"INFP", "ENFP","INFJ", "ENFJ"};
                for (String element : bad) {
                    if(user_mbti.equals(element)) {
                        t2_mbti.setText("ESTJ인 백현이와 궁합이 좋지 않지만..! 백현이는 모든 팬들을 사랑한답니다~!");
                    }
                }
            }
        });

        innerPanel2.add(l1_mbti);
        innerPanel2.add(l2_mbti);
        innerPanel2.add(t1_mbti);
        innerPanel2.add(b_mbti);
        innerPanel2.add(t2_mbti);

        cardPanel.add(panel_test,"test") ;

        // 솔로 플레이리스트 패널 생성
        JPanel panel_solo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_solo.setPreferredSize(new Dimension(1200, 460));

        JTextField t_solo = new JTextField("백현 솔로 플레이리스트");
        t_solo.setFont(font3);
        t_solo.setPreferredSize(new Dimension(1100, 50));
        t_solo.setHorizontalAlignment(JTextField.CENTER);
        t_solo.setEditable(false);
        t_solo.setBackground(Color.WHITE);
        panel_solo.add(t_solo);

        // 유튜브 재생목록 이동 버튼 생성
        imagePath = "../img/youtube.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(85, 50, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JButton b_solo = new JButton(resizedIcon);
        b_solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // www.naver.com으로 연결
                openWebPage("https://youtube.com/playlist?list=PLWyE62_7Ys_1LT3UF1gOLhGnokjuMWhtU&si=xNJvxrAcbtshAAuA");
            }
        });
        b_solo.setPreferredSize(new Dimension(90, 50));
        panel_solo.add(b_solo);


        // 솔로곡 1 썸네일
        imagePath = "../img/s_loveagain.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel solo_label1 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_solo.add(solo_label1);

        // 솔로곡 1 가사창
        solo_label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/loveagain.txt");
            }
        });

        // 솔로곡 1 감상평
        JTextArea solo_area1 = new JTextArea(
                "백현 - Love Again ♬\n"
                +"솔로 미니2집 Delight 7번 트랙\n"
                +"사랑의 끝과 이별의 시작 사이에 서 있는 연인에게 다시 사랑을 갈구하는 가사의 컨템퍼러리 R&B 곡이다.\n"
                +"백현이의 저음이 돋보이는데 풀죽은 얼굴로 다시한번 자기를 사랑해달라고 애원하는 백현이의 모습을 보면\n"
                +"도대체 누가 백현이를 찬 건지 진심으로 이해가 되지 않는다.\n"
                +"가사 중 \"난 이해가 안돼 마음으로는 왜 날 사랑한다 해놓고 더 도망치려 해\"라는 구절은\n"
                +"'백현이를 찬 사람이 아마 회피형 애착유형이지 않았을까?' 라는 상상을 불러 일으킨다.\n"
                +"아니면 그저 이별하는 과정에서 나쁜 사람이 되고 싶지 않은 사람의 핑곗거리일까?\n"
                +"Love Again의 가사를 곱씹어보면 마치 드라마를 보는듯 머리속에 여러 시나리오가 떠오르게 된다."
        );
        solo_area1.setEditable(false);
        Font font6 = new Font("맑은 고딕", Font.PLAIN, 16);
        solo_area1.setFont(font6);
        JScrollPane solo_scroll1 = new JScrollPane(solo_area1);
        solo_scroll1.setPreferredSize(new Dimension(990, 120));
        panel_solo.add(solo_scroll1);

        // 솔로곡 2 썸네일
        imagePath = "../img/s_ost.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel solo_label2 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_solo.add(solo_label2);

        // 솔로곡 2 가사창
        solo_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/ost.txt");
            }
        });

        // 솔로곡 2 감상평
        JTextArea solo_area2 = new JTextArea(
                "백현 - 너를 사랑하고 있어 ♬\n"
                        +"한석규 주연의 SBS 드라마 <낭만닥터 김사부 2>의 메인 OST이다.\n"
                        +"사실 나는 이 드라마를 보지 않아서 자세한 내용은 모른다.\n"
                        +"하지만 가사로 추정컨대 극중 남여 주인공 사이의 절절한 사랑 이야기를 담은 듯하다.\n"
                        +"이 곡을 추천하는 이유는 발라드를 부를 때의 백현이의 목소리를 잘 느낄수 있기 때문!\n"
                        +"백현이의 솔로 앨범에는 주로 리드미컬한 R&B 곡이 많이 수록되어 있지만 사실 백현이는 정통 발라드도 아주 잘부른다.\n"
                        +"OST의 잔잔한 멜로디에 백현이의 감미롭고 부드러운 목소리가 첨가되어 듣고 있으면 마음이 안정되고 기분이 좋아진다."
        );
        solo_area2.setEditable(false);
        solo_area2.setFont(font6);
        JScrollPane solo_scroll2 = new JScrollPane(solo_area2);
        solo_scroll2.setPreferredSize(new Dimension(990, 120));
        panel_solo.add(solo_scroll2);
        
        // 솔로곡 3 썸네일
        imagePath = "../img/s_betcha.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 110, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel solo_label3 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_solo.add(solo_label3);

        // 솔로곡 3 가사창
        solo_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/betcha.txt");
            }
        });

        // 솔로곡 3 감상평
        JTextArea solo_area3 = new JTextArea(
                "백현 - Betcha ♬\n"
                        +"솔로 미니1집 City Lights 3번트랙\n"
                        +"Betcha는 어반 비트의 힙합 R&B 곡으로 상대방이 운명적인 사랑임을 확신하는 남자의 고백을 담고 있다.\n"
                        +"R&B 곡이지만 멜로디가 아주 통통 튀고 상큼해서 귀여운 백현이의 목소리와 더욱 잘 어울리는 곡이다.\n"
                        +"\"우린 운명적 더 깊어지게 될 그런 팔자\"라는 가사를 통해 알 수 있듯이 백현이가 노래 내내 플러팅을 한다...\n"
                        +"이 곡을 들으면 실제로 백현이에게 고백받는 것 같은 기분이 들기 때문에 3분동안 백현이의 썸녀 체험을 할 수 있다!!"
        );
        solo_area3.setEditable(false);
        solo_area3.setFont(font6);
        JScrollPane solo_scroll3 = new JScrollPane(solo_area3);
        solo_scroll3.setPreferredSize(new Dimension(990, 110));
        panel_solo.add(solo_scroll3);

        cardPanel.add(panel_solo,"solo");
        
       
        // 그룹 플레이리스트 패널 생성
        JPanel panel_group = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_group.setPreferredSize(new Dimension(1200, 460));
        JTextField t_group = new JTextField("백현 그룹 플레이리스트");
        t_group.setFont(font3);
        t_group.setPreferredSize(new Dimension(1100, 50));
        t_group.setHorizontalAlignment(JTextField.CENTER);
        t_group.setEditable(false);
        t_group.setBackground(Color.WHITE);
        panel_group.add(t_group);

        // 유튜브 재생목록 이동 버튼 생성
        imagePath = "../img/youtube.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(85, 50, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JButton b_group = new JButton(resizedIcon);
        b_group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // www.naver.com으로 연결
                openWebPage("https://youtube.com/playlist?list=PLWyE62_7Ys_3l3rQ7moaPzwzZyO4uz4W8&si=PJotgvNtAUXpHgcR");
            }
        });
        b_group.setPreferredSize(new Dimension(90, 50));
        panel_group.add(b_group);
        
        // 그룹곡 1 썸네일
        imagePath = "../img/g_creamsoda.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel group_label1 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_group.add(group_label1);

        // 그룹곡 1 가사창
        group_label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/creamsoda.txt");
            }
        });

        // 그룹곡 1 감상평
        JTextArea group_area1 = new JTextArea(
                "엑소 - Cream Soda ♬\n"
                        +"엑소 정규7집 EXIST 타이틀곡\n"
                        +"Cream Soda는 경쾌한 브라스와 건반, 드럼 사운드가 어우러진 팝 댄스 곡으로,\n"
                        +"사랑에 빠진 순간을 부드러우면서도 짜릿한 크림 소다에 빗대어 표현한 가사가 돋보이는 노래다.\n"
                        +"백현이를 비롯한 다른 엑소 멤버들이 군 입대로 인한 4년 간의 공백기를 끝내고 올해 7월 컴백한 곡이다.\n"
                        +"백현이의 쫀득한 도입부로 시작해 가성이 돋보이는 후렴구는 엑소가 왜 보컬맛집인지 알게 해준다.\n"
                        +"오랜만에 컴백해도 빈틈없는 비주얼과 가창력, 빡센 안무를 함께 볼 수 있는 무대를 보길 적극 추천한다.\n"
                        +"30대가 되어도 아이돌력 美친 엑소의 쿨 섹시 바이브를 느낄 수 있는 곡"
        );
        group_area1.setEditable(false);
        group_area1.setFont(font6);
        JScrollPane group_scroll1 = new JScrollPane(group_area1);
        group_scroll1.setPreferredSize(new Dimension(990, 120));
        panel_group.add(group_scroll1);
        
        // 그룹곡 2 썸네일
        imagePath = "../img/g_nabi.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel group_label2 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_group.add(group_label2);

        // 그룹곡 2 가사창
        group_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/nabi.txt");
            }
        });

        // 그룹곡 2 감상평
        JTextArea group_area2 = new JTextArea(
                "엑소 - 나비소녀 (Don't Go) ♬\n"
                        +"엑소 정규1집 리패키지 XOXO (KISS＆HUG) 7번트랙\n"
                        +"엑소의 대표곡 '으르렁 (Growl)'이 포함된 앨범의 수록곡으로 중학생 시절 정말 질리도록 들은 노래다.\n"
                        +"중학생이었던 나는 어느날 음악방송에서 으르렁 대는 잘생긴 오빠들을 보고 처음으로 아이돌에 빠지게 된다.\n"
                        +"풋풋한 사랑의 설레임을 담은 노래 가사는 한창 감수성이 풍부했던 여중생의 마음을 홀려 놓기에 충분했다.\n"
                        +"이 노래를 듣고 있으면 마치 피터팬 속 팅커벨처럼 '나비 소녀'가 된 것 같은 느낌이 든다.\n"
                        +"대표적인 엑소 팬송(fan song)으로 엑소와 팬들을 이어주는 소중한 동화같은 곡이다.\n"
                        +"나비가 나는 모습을 형상화한 안무도 매우 멋있으니 콘서트 직캠을 보길 매우 추천한다"
        );
        group_area2.setEditable(false);
        group_area2.setFont(font6);
        JScrollPane group_scroll2 = new JScrollPane(group_area2);
        group_scroll2.setPreferredSize(new Dimension(990, 120));
        panel_group.add(group_scroll2);
        
        // 그룹곡 3 썸네일
        imagePath = "../img/g_eldorado.png";
        imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("이미지 파일이 존재하지 않습니다.");
            return;
        }
        icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(200, 110, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        JLabel group_label3 = new JLabel(resizedIcon, SwingConstants.CENTER);
        panel_group.add(group_label3);

        // 그룹곡 3 가사창
        group_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow("../lyrics/eldorado.txt");
            }
        });

        // 그룹곡 3 감상평
        JTextArea group_area3 = new JTextArea(
                "엑소 - EL DORADO♬\n"
                        +"정규2집 'EXODUS' 6번트랙\n"
                        +"신비롭고 몽환적이면서도 강렬한 사운드가 돋보이는 댄스곡이다.\n"
                        +"제목 EL DORADO는 과거 대항해시대 당시 남아메리카의 스페인 정복자들 사이에서 전해져 내려오던 전설의 장소로,\n"
                        +"어떤 어려움이 있더라도 엑소 멤버들과 함께라면 낙원을 찾아갈 수 있다는 희망적인 가사를 담고있다.\n"
                        +"엑소 노래는 항상 나에게 이야기 속 주인공이 된 것 같은 느낌을 주는데,\n"
                        +"이 곡은 그중에서도 어드벤쳐 액션 활극 속 주인공이 된 것 같은 기분이 들게 한다.\n"
                        +"\"아무것도 확신 할 수도 기약조차 할 수 없어도 난 지금 떠나려해. 더 큰 모험엔 언제나 위험이 따르는 법\"이라는 가사는\n"
                        +"개인적으로 진로를 바꿔 새로운 도전을 한 나에게 큰 용기를 주었다.\n"
                        +"노래 후반부 \"날 믿어준 그들에게 옳았다고 증명해 보일거야\" 파트는 3옥타브 파까지 내지르는 백현이의 고음이 덧붙여져,\n"
                        +"잠자고 있던 내 마음 속의 패기와 열정을 불러일으킨다.\n"
                        +"가끔 목표를 향해 노력하는게 너무 힘들어 지치고, 마음속에 자꾸 부정적인 생각이 들려할 때 이 노래를 듣고 힘을 낸다."
        );
        group_area3.setEditable(false);
        group_area3.setFont(font6);
        JScrollPane group_scroll3 = new JScrollPane(group_area3);
        group_scroll3.setPreferredSize(new Dimension(990, 110));
        panel_group.add(group_scroll3);

        cardPanel.add(panel_group,"group");


        // 방명록 패널 생성
        JPanel panel_memo = new JPanel();
        panel_memo.setPreferredSize(new Dimension(1200, 460));

        JTextArea guestBookTextArea = new JTextArea("★ 백현이 팬페이지 방문 후기를 적어주세요 ☆\n");
        guestBookTextArea.setEditable(false);
        guestBookTextArea.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        guestBookTextArea.setPreferredSize(new Dimension(1200, 300));
        panel_memo.add(guestBookTextArea);

        JTextField message = new JTextField("");;
        message.setPreferredSize(new Dimension(1200, 50));
        message.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        panel_memo.add(message);

        JButton addButton = new JButton("방명록 추가");
        addButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToGuestBook(guestBookTextArea, message);
                message.setText("");
            }
        });
        panel_memo.add(addButton, BorderLayout.NORTH);

        cardPanel.add(panel_memo,"memo");


        // 카드패널 스위치 버튼 패널 생성
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1000, 35));

        // 스위치 버튼1(궁합 테스트 패널)
        JButton switchToCard1Button = new JButton("백현 궁합 테스트");
        switchToCard1Button.setFont(new Font("맑은 고딕", Font.PLAIN, 16).deriveFont(Font.BOLD));
        switchToCard1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "test");
            }
        });
        buttonPanel.add(switchToCard1Button);

        // 스위치 버튼2(솔로 플레이리스트 패널)
        JButton switchToCard2Button = new JButton("솔로 플레이리스트");
        switchToCard2Button.setFont(new Font("맑은 고딕", Font.PLAIN, 16).deriveFont(Font.BOLD));
        switchToCard2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "solo");
            }
        });
        buttonPanel.add(switchToCard2Button);

        // 스위치 버튼3(그룹 플레이리스트 패널)
        JButton switchToCard3Button = new JButton("그룹 플레이리스트");
        switchToCard3Button.setFont(new Font("맑은 고딕", Font.PLAIN, 16).deriveFont(Font.BOLD));
        switchToCard3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "group");
            }
        });
        buttonPanel.add(switchToCard3Button);

        // 스위치 버튼4(방명록 패널)
        JButton switchToCard4Button = new JButton("팬페이지 방문록");
        switchToCard4Button.setFont(new Font("맑은 고딕", Font.PLAIN, 16).deriveFont(Font.BOLD));
        switchToCard4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "memo");
            }
        });
        buttonPanel.add(switchToCard4Button);


        // 메인패널에 버튼패널과 카드패널 부착
        mainPanel.add(buttonPanel);
        mainPanel.add(cardPanel);

        // frame 기타 설정
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 1100);
        add(mainPanel);
        setVisible(true);
    }


    // 웹페이지 이동 함수
    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 한글 획수 판단 함수
    private static int calculateTotal(String inputText, char[] han, int[] han_num) {
        // 입력된 문자열을 공백(" ")을 기준으로 분리
        char[] characters = inputText.toCharArray();

        int total = 0;
        // 각 글자에 대해 인덱스 찾기
        for (char c : characters) {
            int index = 0;
            for (int i = 0; i < han.length; i++) {
                if (han[i] == c) {
                    index = i;
                    total += han_num[index];
                    break;
                }
            }
        }
        return total;
    }


    // 가사 txt파일을 읽어들여 새창을 여는 함수
    private void openNewWindow(String filePath) {
        JFrame newFrame = new JFrame("가사");
        newFrame.setSize(600, 400);
        JTextArea lyrics = new JTextArea() ;
        Font font = new Font("맑은 고딕", Font.PLAIN, 16);
        lyrics.setFont(font);
        JScrollPane scroll_lyrics = new JScrollPane(lyrics);
        newFrame.add(scroll_lyrics) ;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            lyrics.setText(content.toString());
            lyrics.setCaretPosition(0);  // 텍스트를 설정한 후에 스크롤을 맨 위로 올림
        } catch (IOException e) {
            e.printStackTrace();
        }

        newFrame.setVisible(true);

    }


    // 방명록 추가 함수
    private void addToGuestBook(JTextArea guestBookTextArea, JTextField msgTextField) {
        String message = msgTextField.getText();
        String name = JOptionPane.showInputDialog("방문자 이름:");

        // 사용자가 입력을 취소하거나 아무 내용도 입력하지 않은 경우 처리
        if (message != null && !message.isEmpty()) {
            String entry = name + ": " + message + "\n";
            guestBookTextArea.append(entry);

            // 작성한 방명록 저장 함수 호출
            saveToGuestBook(entry);
        }
    }


    // 작성한 방명록을 txt파일로 저장하는 함수
    private void saveToGuestBook(String entry) {
        String filePath = "guestbook.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Project_20212579();
    }
}