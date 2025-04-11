import os

class ToDoList:
    def __init__(self, filename='todo.txt'):
        self.filename = filename
        self.tasks = []
        self.load_tasks()

    def load_tasks(self):
        if os.path.exists(self.filename):
            with open(self.filename, 'r') as file:
                self.tasks = [line.strip() for line in file.readlines()]

    def save_tasks(self):
        with open(self.filename, 'w') as file:
            for task in self.tasks:
                file.write(task + '\n')

    def add_task(self, task):
        self.tasks.append(task)
        self.save_tasks()
        print(f"Added task: {task}")

    def view_tasks(self):
        if not self.tasks:
            print("No tasks found.")
        else:
            print("\nYour To-Do List:")
            for idx, task in enumerate(self.tasks, start=1):
                print(f"{idx}. {task}")

    def remove_task(self, index):
        if 0 < index <= len(self.tasks):
            removed = self.tasks.pop(index - 1)
            self.save_tasks()
            print(f"Removed task: {removed}")
        else:
            print("Invalid task number.")

# --- Main Menu ---
def main():
    todo = ToDoList()
    while True:
        print("\n--- To-Do List Menu ---")
        print("1. View Tasks")
        print("2. Add Task")
        print("3. Remove Task")
        print("4. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            todo.view_tasks()
        elif choice == '2':
            task = input("Enter the task: ")
            todo.add_task(task)
        elif choice == '3':
            todo.view_tasks()
            try:
                index = int(input("Enter task number to remove: "))
                todo.remove_task(index)
            except ValueError:
                print("Please enter a valid number.")
        elif choice == '4':
            print("Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
