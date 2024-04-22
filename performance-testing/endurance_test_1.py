from locust import HttpUser, task, between
import psutil
import time

class EnduranceTestUser(HttpUser):
    wait_time = between(1, 5)

    @task
    def load_website(self):
        self.client.get("https://automationintesting.online/")

    def monitor_performance(self):
        while True:
            # Monitor memory usage
            memory_usage = psutil.virtual_memory().percent
            print(f"Memory Usage: {memory_usage}%")

            # Monitor CPU utilization
            cpu_utilization = psutil.cpu_percent()
            print(f"CPU Utilization: {cpu_utilization}%")

            # Monitor database performance
            # Add your database monitoring code here

            time.sleep(5)  # Adjust the sleep duration as needed

    def on_start(self):
        self.monitor_performance()