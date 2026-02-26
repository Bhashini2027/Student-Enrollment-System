import os

dir_path = r"C:\Users\user\.gemini\antigravity\brain\5d707074-9d1f-46fd-b3c7-fa5c3f56532b"
parts = ["Case_Study_Report_Part1.md", "Case_Study_Report_Part2.md", "Case_Study_Report_Part3.md"]

with open(os.path.join(dir_path, "Case_Study_Report.md"), "w", encoding="utf-8") as outfile:
    for part in parts:
        with open(os.path.join(dir_path, part), "r", encoding="utf-8") as infile:
            outfile.write(infile.read())
            outfile.write("\n\n")

print("Files concatenated successfully.")
