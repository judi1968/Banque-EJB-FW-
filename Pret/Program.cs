
using Microsoft.EntityFrameworkCore;
using Pret.Data;
using Pret.Services;

var builder = WebApplication.CreateBuilder(args);


// Ajouter DbContext
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseNpgsql(builder.Configuration.GetConnectionString("DefaultConnection")));


// Ajouter services pour controllers
builder.Services.AddControllers();

// Ajouter le service PersonneService
builder.Services.AddScoped<PersonneService>();
builder.Services.AddScoped<MouvementPretService>();
builder.Services.AddScoped<MontantPersonneService>();


// Add services to the container.
builder.Services.AddControllersWithViews();

builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNameCaseInsensitive = true;
    });


var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseRouting();

app.UseAuthorization();

app.MapStaticAssets();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}")
    .WithStaticAssets();

app.MapControllers();

app.Run();
