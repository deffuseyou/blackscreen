/*  BlackScreen
 *  Copyright (C) 2010 Mike Schwartz, http://officialspeed.tk/
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

#include <gtk/gtk.h>
#include <gdk/gdk.h>

int main (int argc, char **argv) {
  GtkWidget *window = NULL;
  GdkCursor *cursor = NULL;
    GdkColor color;
      color.red = 0;
      color.green = 0;
      color.blue = 0;
  gtk_init(&argc, &argv);

  window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
  cursor = gdk_cursor_new(GDK_BLANK_CURSOR);
  gtk_window_set_title (GTK_WINDOW (window), "BlackScreen");
  gtk_widget_modify_bg(window, GTK_STATE_NORMAL, &color);
  g_signal_connect (G_OBJECT (window), "delete-event", gtk_main_quit, NULL);
  gtk_window_fullscreen(window);
  gtk_window_set_position(GTK_WINDOW(window), GTK_WIN_POS_CENTER);
  gtk_widget_show_all(window);
  gdk_window_set_cursor (GTK_WIDGET (window)->window, cursor);

  gtk_main();
  return 0;
}
