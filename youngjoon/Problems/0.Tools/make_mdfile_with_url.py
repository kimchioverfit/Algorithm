import requests
import json
import re
from datetime import datetime
import os
from bs4 import BeautifulSoup

def slug_from_url(url: str) -> str:
    """URL에서 슬러그 추출"""
    match = re.search(r"/problems/([^/]+)/", url)
    if not match:
        raise ValueError("URL에서 문제 슬러그를 추출할 수 없습니다.")
    return match.group(1)

def get_problem_data(slug: str):
    """GraphQL API로 문제 데이터 요청"""
    url = "https://leetcode.com/graphql"
    query = """
    query getQuestionDetail($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionId
        title
        content
        difficulty
      }
    }
    """
    variables = {"titleSlug": slug}
    payload = {
        "query": query,
        "variables": variables
    }
    headers = {
        "Content-Type": "application/json",
        "Referer": f"https://leetcode.com/problems/{slug}/"
    }

    response = requests.post(url, headers=headers, json=payload)
    if response.status_code != 200:
        raise Exception(f"GraphQL 요청 실패: {response.status_code}")

    data = response.json()["data"]["question"]
    return data


def html_to_markdown(html: str) -> str:
    """LeetCode HTML content를 마크다운 텍스트로 변환 + Example 블록 분리 처리 + 빈 줄로 구분"""
    soup = BeautifulSoup(html, "html.parser")
    lines = soup.get_text().splitlines()
    cleaned = []
    example_block = []

    inside_example = False

    for line in lines:
        stripped = line.strip()

        # 빈 줄 처리
        if not stripped:
            if inside_example:
                example_block.append(">")
            else:
                cleaned.append("")
            continue

        # Example 시작
        if re.match(r"example\s*\d*[:：]", stripped, re.IGNORECASE):
            # 이전 Example 블록 저장 후 빈 줄로 구분
            if example_block:
                cleaned.append("\n".join(example_block))
                cleaned.append("")  # ✅ 블록 구분용 빈 줄
                example_block = []

            inside_example = True
            example_block.append(f"> **{stripped.rstrip(':：')}**")
            continue

        # Example 내부 처리
        if inside_example:
            # 다음 섹션 시작이면 example 종료
            if re.match(r"(constraints|note|follow up)", stripped, re.IGNORECASE):
                if example_block:
                    cleaned.append("\n".join(example_block))
                    cleaned.append("")  # ✅ 블록 구분용 빈 줄
                    example_block = []
                inside_example = False
                cleaned.append(stripped)
            else:
                example_block.append(f"> {stripped}")
        else:
            cleaned.append(stripped)

    # 마지막 example 처리
    if example_block:
        cleaned.append("\n".join(example_block))
        cleaned.append("")  # ✅ 마지막 블록 구분용 빈 줄

    return "\n".join(cleaned).strip()




def make_markdown(slug_url: str, output_dir="."):
    slug = slug_from_url(slug_url)
    data = get_problem_data(slug)

    question_id = data["questionId"]
    title = data["title"]
    difficulty = data["difficulty"]
    description_html = data["content"]

    # 설명 & 예제 텍스트 처리
    full_text = html_to_markdown(description_html)

    # 날짜 및 파일명 생성
    now = datetime.now()
    date_str = now.strftime("%Y-%m-%d %H:%M:%S +0900")
    date_filename = now.strftime("%Y-%m-%d")
    safe_title = re.sub(r"[^\w\-]", "-", title.lower().replace(" ", "-"))
    filename = f"{question_id}. {title}.md"
    output_path = os.path.join(output_dir, filename)

    # 마크다운 포맷
    markdown = f"""---
layout: post
title: {question_id}. {title}
category: leetcode
date: {date_str}
description: {slug_url}
img: leetcode.png
fig-caption:
status: success
difficulty: {difficulty}
---

# {question_id}. {title}

{full_text}
"""

    with open(output_path, "w", encoding="utf-8") as f:
        f.write(markdown)

    print(f"✅ 생성 완료: {output_path}")

if __name__ == "__main__":
    url = "https://leetcode.com/problems/find-the-original-typed-string-ii/?envType=daily-question&envId=2025-07-04"
    make_markdown(url)
