# [Silver IV] UDPC 파티 - 27919 

[문제 링크](https://www.acmicpc.net/problem/27919) 

### 성능 요약

메모리: 33240 KB, 시간: 48 ms

### 분류

그리디 알고리즘

### 제출 일자

2024년 10월 4일 19:32:03

### 문제 설명

<p>Yunee, Ponix, and Dalgoo decided to gather in one place to celebrate holding the UDPC and hold a party! While having a great time with numerous participants, suddenly the participants started debating which of the three mascots is the cutest.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f7268d94-658d-4027-b199-e597588ef49c/-/preview/" style="height: 250px; width: 250px;"></p>

<p style="color: rgb(170, 170, 170); font-style: italic; text-align: center;">UNIST mascot 'Yunee' - Source: 윤찐빵</p>

<p style="text-align: center;">Hey, no matter how you look at it, our Yunee is the cutest. Look at the dainty horns and charming mane!</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/839c5606-12cd-4316-834b-b4117c5dfe19/-/preview/" style="height: 251px; width: 250px;"></p>

<p style="color: rgb(170, 170, 170); font-style: italic; text-align: center;">POSTECH mascot 'Ponix' - Source: POSTECH website</p>

<p style="text-align: center;">Then, what about our ponix’s mane? He has adorable wings and a tail too~</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/7618b946-87db-4d6d-8bb2-616ecfc25b26/-/preview/" style="height: 249px; width: 250px;"></p>

<p style="color: rgb(170, 170, 170); font-style: italic; text-align: center;">DGIST mascot 'Dalgoo' - Source: Terapin, Inc. website</p>

<p style="text-align: center;">Anyway, Our Dalgoo is the cutest, right? Not only the features but also the chubby body and Bungeoppang(Fish-shaped cake) are so cute!</p>

<p>The discussion showed no sign of ending, and the tired participants decided to vote on who is the cutest. They wrote down only one alphabet among <code>U</code>, <code>D</code>, <code>P</code>, or <code>C</code> on a piece of paper and put it in the ballot box. Each alphabet stands for Yunee, Dalgoo, Ponix, and abstention. If the number of votes received by one mascot is strictly greater than the number of votes each received by the other two mascots, that mascot will be crowned the cutest mascot!</p>

<p>After all the voting was over, the three mascots started counting the votes. However, the fonts and directions of the alphabet were so diverse, that it was impossible to distinguish similar-looking alphabets — between <code>U</code> and <code>C,</code> and between <code>D</code> and <code>P</code>. Thus, the ballot counting result had been a mess!</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/4291cad2-a794-426d-bd55-4bff20a1cb7a/-/crop/680x221/80,20/-/preview/" style="width: 462px; height: 150px;"></p>

<p style="text-align: center;">Is it U or C? The answer is UUUU!</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/5f29aee5-af30-42c2-8fb9-a69c47da71e7/-/crop/564x211/92,253/-/preview/" style="width: 401px; height: 150px;"></p>

<p style="text-align: center;">Is it D or P? The answer is DPDP!</p>

<p>When the participants' vote is given, find out who can be crowned the cutest mascot considering that <code>U</code> and <code>C</code>, <code>D</code> and <code>P</code> can be interchanged in the results.</p>

### 입력 

 <p>The first line of input data contains a single string <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D449 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>V</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$V$</span></mjx-container> — the participants' votes. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D449 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>V</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$V$</span></mjx-container> contains only <span style="color:#e74c3c;"><code>U</code></span>, <span style="color:#e74c3c;"><code>D</code></span>, <span style="color:#e74c3c;"><code>P</code></span>, and <span style="color:#e74c3c;"><code>C</code></span>, and the length of <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D449 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>V</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$V$</span></mjx-container> is strictly greater than <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container> and does not exceed <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mtext class="mjx-n"><mjx-c class="mjx-cA0"></mjx-c></mjx-mtext><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>100</mn><mtext> </mtext><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$100\ 000$</span></mjx-container>.</p>

### 출력 

 <p>In a single line, print some alphabets — <span style="color:#e74c3c;"><code>U</code></span> if Yunee can be crowned the cutest mascot, <span style="color:#e74c3c;"><code>D</code></span> if Dalgoo can, and <span style="color:#e74c3c;"><code>P</code></span> if Ponix can.</p>

<p>Print <strong>all alphabets</strong> of the mascots who can be crowned the cutest mascot in this order.</p>

<p>If you don't print any of <span style="color:#e74c3c;"><code>U</code></span>, <span style="color:#e74c3c;"><code>D</code></span> and <span style="color:#e74c3c;"><code>P</code></span>, then print <span style="color:#e74c3c;"><code>C</code></span>.</p>

